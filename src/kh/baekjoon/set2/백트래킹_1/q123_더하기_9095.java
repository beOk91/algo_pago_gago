package kh.baekjoon.set2.백트래킹_1;

import java.io.*;

public class q123_더하기_9095 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int T, n, answer;


    private static void solution() throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int w = 0; w < T; w++) {
            answer = 0;
            n = Integer.parseInt(br.readLine());
            dfs(0);
            bw.write(answer + "\n");
        }
    }

    private static void dfs(int tot) {
        if (tot > n) {
            return;
        }
        if (tot == n) {
            answer++;
        }

        for (int i = 1; i <= 3; i++) {
            dfs(tot + i);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}
