package kh.baekjoon.set3.DFS와_BFS_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 치즈_2636 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, M;
    private static int[][] cheese;
    private static boolean[][] visit;
    private static int cheeseCount = 0;
    private static int meltCount = 0;

    private static int[] di = {-1, 0, 1, 0};
    private static int[] dj = {0, 1, 0, -1};

    private static void input() throws IOException {
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        cheese = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(line[j]);
                if (cheese[i][j] == 1) {
                    cheeseCount++;
                }
            }
        }
    }



    private static class Node {
        int i;
        int j;


        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static void solution() throws IOException {
        int answer1 = 0;
        int answer2 = 0;

        while(cheeseCount != meltCount) {
            answer1++;
            List<Node> sideList = new ArrayList<>();
            visit = new boolean[N][M];
            dfs(0, 0, true, sideList);
            if (meltCount + sideList.size() == cheeseCount) {
                answer2 = sideList.size();
            }
            meltCount += sideList.size();
            for (Node node : sideList) {
                cheese[node.i][node.j] = 0;
            }
        }

        bw.write(answer1 + "\n");
        bw.write(answer2 + "\n");
    }

    private static void dfs(int i, int j, boolean isAirBefore, List<Node> sideList) {
        if (i < 0 || i == N || j < 0 || j == M) {
            return;
        }
        if (visit[i][j] || !isAirBefore) {
            return;
        }

        visit[i][j] = true;
        boolean isSide = isAirBefore && cheese[i][j] == 1;

        if(isSide) {
            sideList.add(new Node(i, j));
        }

        for (int w = 0; w < 4; w++) {
            dfs(i + di[w], j + dj[w], cheese[i][j] == 0, sideList);
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