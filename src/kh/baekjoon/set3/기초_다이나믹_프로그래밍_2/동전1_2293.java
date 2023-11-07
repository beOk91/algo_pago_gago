package kh.baekjoon.set3.기초_다이나믹_프로그래밍_2;

import java.io.*;
import java.util.Arrays;

public class 동전1_2293 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int n, k;
    private static int[] nums;

    private static void input() throws IOException {
        String[] line = br.readLine().split(" ");

        n = Integer.parseInt(line[0]);
        k = Integer.parseInt(line[1]);
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void solution() throws IOException {
        long[] dp = new long[k + 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] <= k) {
                dp[nums[i]]++;
                for (int j = nums[i] + 1; j <= k; j++) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }

        bw.write(dp[k] + "\n");
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}