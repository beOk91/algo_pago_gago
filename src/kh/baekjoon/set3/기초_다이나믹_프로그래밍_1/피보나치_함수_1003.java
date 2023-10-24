package kh.baekjoon.set3.기초_다이나믹_프로그래밍_1;


import java.io.*;

public class 피보나치_함수_1003 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int T;

    private static void input() throws IOException {
        String line = br.readLine();
        T = Integer.parseInt(line);
    }

    private static void solution() throws IOException {
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                bw.write("1 0\n");
            }
            else if (num == 1) {
                bw.write("0 1\n");
            }
            else {
                int[][] dp = new int[2][num + 1];

                dp[0][0] = 1;
                dp[0][1] = 0;
                dp[1][0] = 0;
                dp[1][1] = 1;

                for (int n = 2; n <= num; n++) {
                    dp[0][n] = dp[0][n - 1] + dp[0][n - 2];
                    dp[1][n] = dp[1][n - 1] + dp[1][n - 2];
                }

                bw.write(dp[0][num] + " " + dp[1][num] + "\n");
            }
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