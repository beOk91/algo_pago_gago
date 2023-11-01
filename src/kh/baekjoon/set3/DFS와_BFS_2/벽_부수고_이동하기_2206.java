package kh.baekjoon.set3.DFS와_BFS_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 벽_부수고_이동하기_2206 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, M;
    private static int[][] map;

    private static int[] di = {-1, 0, 1, 0};
    private static int[] dj = {0, 1, 0, -1};

    private static void input() throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = row[j] - '0';
            }
        }
    }

    private static void solution() throws IOException {
        int answer = bfs();

        bw.write(answer + "\n");
    }

    private static class Pos {
        int i;
        int j;
        int cnt;
        boolean crashed;

        Pos(int i, int j, int cnt, boolean crashed) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.crashed = crashed;
        }
    }

    private static int bfs() {
        int answer = -1;
        Queue<Pos> q = new LinkedList<>();
        boolean[][][] visit = new boolean[N][M][2];
        Pos start = new Pos(0, 0, 1, false);
        q.add(start);
        visit[0][0][0] = true;

        while(!q.isEmpty()) {
            Pos cur = q.remove();
            if (cur.i == N - 1 && cur.j == M - 1) {
                answer = cur.cnt;
                break;
            }

            for (int w = 0; w < 4; w++) {
                int nextI = cur.i + di[w];
                int nextJ = cur.j + dj[w];

                if (nextI < 0 || nextI == N || nextJ < 0 || nextJ == M) {
                    continue;
                }
                if (map[nextI][nextJ] == 1) {
                    if (cur.crashed || visit[nextI][nextJ][1]) {
                        continue;
                    }
                    visit[nextI][nextJ][1] = true;
                    Pos nextNode = new Pos(nextI, nextJ, cur.cnt + 1, true);
                    q.add(nextNode);
                }
                else {
                    if (visit[nextI][nextJ][cur.crashed ? 1 : 0]) {
                        continue;
                    }
                    visit[nextI][nextJ][cur.crashed ? 1 : 0] = true;
                    Pos nextNode = new Pos(nextI, nextJ, cur.cnt + 1, cur.crashed);
                    q.add(nextNode);
                }
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
