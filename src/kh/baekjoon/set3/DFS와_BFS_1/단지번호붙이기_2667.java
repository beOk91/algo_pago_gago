package kh.baekjoon.set3.DFS와_BFS_1;

import java.io.*;
import java.util.PriorityQueue;

public class 단지번호붙이기_2667 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int[][] board;
    private static final int[] DI = {-1, 0, 1, 0};
    private static final int[] DJ = {0, 1, 0, -1};

    private static int grpCnt = 0;
    private static int cnt;
    private static boolean[][] visit;

    private static void input() throws IOException {
        String line = br.readLine();

        N = Integer.parseInt(line);
        board = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            char[] charArray = line.toCharArray();
            for (int j = 0; j < N; j++) {
                board[i][j] = charArray[j] - '0';
            }
        }
    }

    private static void solution() throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && board[i][j] > 0) {
                    grpCnt++;
                    cnt = 0;
                    dfs(i, j);
                    pq.add(cnt);
                }
            }
        }

        bw.write(grpCnt + "\n");
        while (!pq.isEmpty()) {
            bw.write(pq.remove() + "\n");
        }

    }

    private static void dfs(int i, int j) {
        if (i < 0 || i == N || j < 0 || j == N
                || visit[i][j]
                || board[i][j] == 0) {
            return;
        }

        visit[i][j] = true;
        cnt++;

        for (int w = 0; w < 4; w++) {
            dfs(i + DI[w], j + DJ[w]);
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