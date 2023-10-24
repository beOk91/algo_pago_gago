package kh.baekjoon.set3.기초_다이나믹_프로그래밍_1;

import java.io.*;

public class _1로_만들기_1463 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    private static void solution() throws IOException {
        int[] dp = new int[N + 1];

        if (N == 1) {
            bw.write("0\n");
        }
        else {
            dp[2] = 1;
            if (N > 2) {
                dp[3] = 1;

                for (int i = 4; i <= N; i++) {
                    if (i % 3 == 0 && i % 2 == 0) {
                        dp[i] = Math.min(Math.min(dp[i / 3], dp[i / 2]), dp[i - 1]) + 1;
                    } else if (i % 3 == 0) {
                        dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
                    } else if (i % 2 == 0) {
                        dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
                    } else {
                        dp[i] = dp[i - 1] + 1;
                    }
                }
            }
            bw.write(dp[N] + "\n");
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