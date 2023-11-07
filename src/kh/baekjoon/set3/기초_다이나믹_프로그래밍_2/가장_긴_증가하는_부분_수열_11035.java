package kh.baekjoon.set3.기초_다이나믹_프로그래밍_2;

import java.io.*;

public class 가장_긴_증가하는_부분_수열_11035 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int[] A;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        String[] line = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(line[i]);
        }
    }

    private static void solution() throws IOException {
        int answer = 1;

        int[] dp = new int[N];
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            int next = 0;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    next = Math.max(next, dp[j]);
                }
            }
            dp[i] = next + 1;
            answer = Math.max(answer, dp[i]);
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