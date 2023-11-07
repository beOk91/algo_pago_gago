package kh.baekjoon.set3.기초_다이나믹_프로그래밍_2;

import java.io.*;

public class boj_2xn_타일링_2_11727 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int n;

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
    }

    private static void solution() throws IOException {
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = (2 * dp[i - 1] + 1) % 10007;
            }
            else {
                dp[i] = (2 * dp[i - 1] - 1) % 10007;
            }
        }

        bw.write(dp[n] + "\n");
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}