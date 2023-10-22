package kh.baekjoon.set2.백트래킹_2;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 치킨_배달_15686 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, M, answer;
    private static int[][] city;
    private static int[] di = {-1, 0, 1, 0};
    private static int[] dj = {0, 1, 0, -1};
    private static List<Pos> shop;

    private static void input() throws IOException {
        String[] line;
        line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        city = new int[N][N];
        shop = new ArrayList<>();
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(line[j]);
                if (city[i][j] == 2) {
                    shop.add(new Pos(i, j, 0));
                }
            }
        }
    }

    private static class Pos {
        int i;
        int j;
        int len;

        Pos(int i, int j, int len) {
            this.i = i;
            this.j = j;
            this.len = len;
        }
    }

    private static int chickenDistance(int startI, int startJ) {
        int answer = 0;
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];

        q.add(new Pos(startI, startJ, 0));
        visit[startI][startJ] = true;

        while(!q.isEmpty()) {
            Pos cur = q.remove();

            if (city[cur.i][cur.j] == 2) {
                answer = cur.len;
                break;
            }

            for (int w = 0; w < 4; w++) {
                if (cur.i + di[w] < 0 || cur.i + di[w] == N || cur.j + dj[w] < 0 || cur.j + dj[w] == N) {
                    continue;
                }
                if (visit[cur.i + di[w]][cur.j + dj[w]]) {
                    continue;
                }
                q.add(new Pos(cur.i + di[w], cur.j + dj[w], cur.len + 1));
                visit[cur.i + di[w]][cur.j + dj[w]] = true;
            }
        }

        return answer;
    }

    private static void dfs(int idx, int lev) {
        if (lev == shop.size() - M) {
            answer = Math.min(answer, getCityChickenDistance());
            return;
        }

        for (int i = idx; i < shop.size(); i++) {
            Pos pos = shop.get(i);
            if (city[pos.i][pos.j] == 2){
                city[pos.i][pos.j] = 0;
                dfs(i, lev + 1);
                city[pos.i][pos.j] = 2;
            }
        }
    }

    private static int getCityChickenDistance() {
        int cityChickenDistance = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (city[i][j] == 1) {
                    cityChickenDistance += chickenDistance(i, j);
                }
            }
        }

        return cityChickenDistance;
    }

    private static void solution() throws IOException {
        dfs(0, 0);
        bw.write(answer + "\n");
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}
