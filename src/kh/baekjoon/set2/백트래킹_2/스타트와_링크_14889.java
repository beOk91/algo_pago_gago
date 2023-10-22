package kh.baekjoon.set2.백트래킹_2;

import java.io.*;
import java.util.*;

public class 스타트와_링크_14889 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, answer;
    private static int[][] stat;
    private static boolean[] team;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        stat = new int[N][N];
        answer = Integer.MAX_VALUE;
        team = new boolean[N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                stat[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    private static void solution() throws IOException {
        makeTeam(0, 0);

        bw.write(answer + "\n");
    }

    // 0 ~ N
    private static void makeTeam(int idx, int lev) {
        if (lev == (N / 2)) {
            answer = Math.min(diff(), answer);
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!team[i]) {
                team[i] = true;
                makeTeam(i, lev + 1);
                team[i] = false;
            }
        }
    }

    private static int diff() {
        int teamStat = 0;
        int oppoStat = 0;

        for (int i = 0; i < team.length - 1; i++) {
            for (int j = i + 1; j < team.length; j++) {
                if (team[i] && team[j]) {
                    teamStat += stat[i][j];
                    teamStat += stat[j][i];
                }
                if (!team[i] && !team[j]) {
                    oppoStat += stat[i][j];
                    oppoStat += stat[j][i];
                }
            }
        }
        return Math.abs(teamStat - oppoStat);
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}
