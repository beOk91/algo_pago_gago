package kh.baekjoon.set3.기초_다이나믹_프로그래밍_1;

import java.io.*;

public class RGB거리_1149 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int[][] cost;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    private static void solution() throws IOException {
        int[][] dp = new int[N][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = cost[0][i];
        }

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }

        bw.write(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]) + "\n");
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}