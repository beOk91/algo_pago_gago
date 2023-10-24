package kh.baekjoon.set3.기초_다이나믹_프로그래밍_1;

import java.io.*;

public class 계단_오르기_2579 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int arr[];

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void solution() throws IOException {

        if (N == 1) {
            bw.write(arr[0] + "\n");
        } else if (N == 2) {
            bw.write((arr[0] + arr[1]) + "\n");
        } else {
            int[][] dp = new int[2][N];

            dp[0][0] = arr[0];
            dp[0][1] = arr[0] + arr[1];
            dp[1][1] = arr[1];

            for (int i = 2; i < N; i++) {
                dp[0][i] = dp[1][i - 1] + arr[i];
                dp[1][i] = Math.max(dp[0][i - 2], dp[1][i - 2]) + arr[i];
            }

            bw.write(Math.max(dp[0][N - 1], dp[1][N - 1]) + "\n");
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