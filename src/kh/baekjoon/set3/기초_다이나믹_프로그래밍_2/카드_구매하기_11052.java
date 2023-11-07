package kh.baekjoon.set3.기초_다이나믹_프로그래밍_2;

import java.io.*;

public class 카드_구매하기_11052 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int[] arr;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(line[i - 1]);
        }
    }

    private static void solution() throws IOException {
        int[] dp = new int[N + 1];

        dp[1] = arr[1];

        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                dp[j] = Math.max(dp[j], Math.max(arr[i], dp[j - i] + arr[i]));
            }
        }

        bw.write(dp[N] + "\n");
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}