package kh.baekjoon.set3.기초_다이나믹_프로그래밍_2;

import java.io.*;

public class 연속합_1912 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int n;
    private static int[] nums;

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }
    }

    private static void solution() throws IOException {
        int[] dp = new int[n];
        int answer = nums[0];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            answer = Math.max(dp[i], answer);
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
