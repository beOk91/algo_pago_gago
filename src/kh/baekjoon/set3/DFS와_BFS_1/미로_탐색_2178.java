package kh.baekjoon.set3.DFS와_BFS_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 미로_탐색_2178 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, M;
    private static int[][] board;
    private static boolean[][] visit;

    private static final int[] DI = {-1, 0, 1, 0};
    private static final int[] DJ = {0, 1, 0, -1};

    private static void input() throws IOException {
        String line = br.readLine();
        N = Integer.parseInt(line.split(" ")[0]);
        M = Integer.parseInt(line.split(" ")[1]);

        board = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            line = br.readLine();
            char[] charArray = line.toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = charArray[j] - '0';
            }
        }
    }

    private static void solution() throws IOException {
        int answer = bfs();

        bw.write(answer + "\n");
    }

    private static class State {
        int i;
        int j;
        int count;

        State(int i, int j, int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }

    private static int bfs() {
        int answer = 0;
        Queue<State> q = new LinkedList<>();

        q.add(new State(0, 0, 1));

        while(!q.isEmpty()) {
            State cur = q.remove();
            int i = cur.i;
            int j = cur.j;

            if (i == N - 1 && j == M - 1) {
                answer = cur.count;
                break;
            }

            for (int w = 0; w < 4; w++) {
                if (i + DI[w] < 0 || i + DI[w] == N || j + DJ[w] < 0 || j + DJ[w] == M
                        || visit[i + DI[w]][j + DJ[w]]
                        || board[i + DI[w]][j + DJ[w]] == 0) {
                    continue;
                }
                q.add(new State(i + DI[w], j + DJ[w], cur.count + 1));
                visit[i + DI[w]][j + DJ[w]] = true;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}
