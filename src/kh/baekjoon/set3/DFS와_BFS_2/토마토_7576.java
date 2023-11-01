package kh.baekjoon.set3.DFS와_BFS_2;

import java.io.*;
import java.util.*;

public class 토마토_7576 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, M;
    private static int[][] tomatoes;
    private static boolean[][] visit;
    private static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
        return o1.day.compareTo(o2.day);
    });

    private static int ripeCount = 0;
    private static int tomatoCount = 0;

    private static int[] di = {-1, 0, 1, 0};
    private static int[] dj = {0, 1, 0, -1};

    private static void input() throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[1]);
        M = Integer.parseInt(line[0]);

        tomatoes = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(line[j]);
                if (tomatoes[i][j] == 1 || tomatoes[i][j] == 0) {
                    tomatoCount++;
                }
                if (tomatoes[i][j] == 1) {
                    pq.add(new Node(i, j, 0));
                }
            }
        }
    }

    private static void solution() throws IOException {
        int answer = bfs();

        bw.write(completed() ? answer + "\n" : "-1\n");
    }

    private static boolean completed() {
        return tomatoCount == ripeCount;
    }

    private static class Node {
        int i;
        int j;
        Integer day;

        Node(int i, int j, int day) {
            this.i = i;
            this.j = j;
            this.day = day;
        }
    }

    private static int bfs() {
        int answer = 0;

        while(!pq.isEmpty()) {
            Node ripe = pq.remove();

            ripeCount++;
            answer = Math.max(answer, ripe.day);

            for (int w = 0; w < 4; w++) {
                int nextI = ripe.i + di[w];
                int nextJ = ripe.j + dj[w];

                if (nextI < 0 || nextI == N || nextJ < 0 || nextJ == M) {
                    continue;
                }
                if (tomatoes[nextI][nextJ] != 0 || visit[nextI][nextJ]) {
                    continue;
                }

                pq.add(new Node(nextI, nextJ, ripe.day + 1));
                visit[nextI][nextJ] = true;
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
