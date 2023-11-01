package kh.baekjoon.set3.DFS와_BFS_2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토_7569 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int M, N, H;

    private static int[][][] tomatoes;
    private static boolean[][][] riped;
    private static int tomatoCount = 0;
    private static int ripedCount = 0;
    private static Queue<Node> q = new LinkedList<>();

    private static int[] di = {-1, 0, 1, 0, 0, 0};
    private static int[] dj = {0, 1, 0, -1, 0, 0};
    private static int[] dk = {0, 0, 0, 0, 1, -1};

    private static void input() throws IOException {
        String[] line = br.readLine().split(" ");
        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        H = Integer.parseInt(line[2]);

        tomatoes = new int[N][M][H];
        riped = new boolean[N][M][H];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                line = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    tomatoes[i][j][k] = Integer.parseInt(line[j]);

                    if (tomatoes[i][j][k] == 1 || tomatoes[i][j][k] == 0) {
                        tomatoCount++;
                    }
                    if (tomatoes[i][j][k] == 1) {
                        riped[i][j][k] = true;
                        q.add(new Node(i, j, k, 0));
                    }
                }
            }
        }
    }

    private static class Node {
        int i;
        int j;
        int k;
        Integer cnt;

        Node(int i, int j, int k, int cnt) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.cnt = cnt;
        }
    }

    private static void solution() throws IOException {
        int answer = bfs();

        bw.write(answer + "\n");
    }

    private static int bfs() {
        int answer = 0;

        while(!q.isEmpty()) {
            Node node = q.remove();

            answer = Math.max(answer, node.cnt);
            ripedCount++;

            for (int w = 0; w < 6; w++) {
                int nextI = node.i + di[w];
                int nextJ = node.j + dj[w];
                int nextK = node.k + dk[w];

                if (nextI < 0 || nextI == N || nextJ < 0 || nextJ == M || nextK < 0 || nextK == H) {
                    continue;
                }

                if (riped[nextI][nextJ][nextK] || tomatoes[nextI][nextJ][nextK] == -1) {
                    continue;
                }

                riped[nextI][nextJ][nextK] = true;
                tomatoes[nextI][nextJ][nextK] = 1;
                q.add(new Node(nextI, nextJ, nextK, node.cnt + 1));
            }
        }

        return complete() ? answer : -1;
    }

    private static boolean complete() {
        return tomatoCount == ripedCount;
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}
