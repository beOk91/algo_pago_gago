package kh.baekjoon.set3.기초_다이나믹_프로그래밍_1;

import java.io.*;

public class 정수_삼각형_1932 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int n;
    private static int[][] triangle;

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    private static void solution() throws IOException {

        if (n > 1) {
            int[][] dp = new int[n][n];
            dp[0][0] = triangle[0][0];
            int answer = Integer.MIN_VALUE;

            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0) {
                        dp[i][j] = triangle[i][j] + dp[i - 1][j];
                    } else if (j == i) {
                        dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                    }

                    if (i == n - 1) {
                        answer = Math.max(dp[i][j], answer);
                    }
                }
            }

            bw.write(answer + "\n");
        }
        else {
            bw.write(triangle[0][0] + "\n");
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
