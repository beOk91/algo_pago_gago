package kh.baekjoon.set3.기초_다이나믹_프로그래밍_2;

import java.io.*;

public class 포도주_시식_2156 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int n;
    private static int[] nums;

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void solution() throws IOException {
        int[] dp = new int[n];
        int answer = 0;


        if (n == 1) {
            answer = nums[0];
        }
        else if (n == 2) {
            answer = nums[0] + nums[1];
        }
        else {
            dp[0] = nums[0];
            dp[1] = dp[0] + nums[1];
            dp[2] = Math.max(nums[0] + nums[1], nums[1] + nums[2]);
            dp[2] = Math.max(nums[0] + nums[2], dp[2]);
            answer = Math.max(dp[1], dp[2]);

            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(dp[i - 3] + nums[i - 1], dp[i - 2]) + nums[i];
                dp[i] = Math.max(dp[i], dp[i - 1]);

                answer = Math.max(answer, dp[i]);
            }
        }
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