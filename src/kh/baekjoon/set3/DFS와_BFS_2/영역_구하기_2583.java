package kh.baekjoon.set3.DFS와_BFS_2;

import java.io.*;
import java.util.PriorityQueue;

public class 영역_구하기_2583 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, M, K;
    private static int[][] board;
    private static int[][] rectangles;
    private static boolean[][] visit;
    private static int cnt;
    private static int[] di = {-1, 0, 1, 0};
    private static int[] dj = {0, 1, 0, -1};

    private static void input() throws IOException {
        String[] line = br.readLine().split(" ");
        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        K = Integer.parseInt(line[2]);

        board = new int[M][N];
        visit = new boolean[M][N];
        rectangles = new int[K][4];

        for (int i = 0; i < K; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < 4; j++) {
                rectangles[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int w = 0; w < K; w++) {
            int[] rectangle = rectangles[w];

            int startI = M - rectangle[3];
            int startJ = rectangle[0];

            int endI = M - rectangle[1];
            int endJ = rectangle[2];

            for (int i = startI; i < endI; i++) {
                for (int j = startJ; j < endJ; j++) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private static void solution() throws IOException {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0 && !visit[i][j]) {
                    cnt = 0;
                    answer++;
                    dfs(i, j);
                    pq.add(cnt);
                }
            }
        }

        bw.write(answer + "\n");

        while(!pq.isEmpty()) {
            bw.write(pq.remove() + (pq.isEmpty() ? "\n" :" "));
        }

    }

    private static void dfs(int i, int j) {
        if (i < 0 || i == M || j < 0 || j == N) {
            return;
        }
        if (visit[i][j] || board[i][j] == 1) {
            return;
        }

        visit[i][j] = true;
        cnt++;

        for (int w = 0; w < 4; w++) {
            dfs(i + di[w], j + dj[w]);
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}