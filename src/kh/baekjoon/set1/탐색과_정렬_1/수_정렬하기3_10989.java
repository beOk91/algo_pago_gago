package kh.baekjoon.set1.탐색과_정렬_1;

import java.io.*;

public class 수_정렬하기3_10989 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int[] arr;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[10001];
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine())]++;
        }
    }

    private static void solution() throws IOException {
        for (int i = 1; i < 10001; i++) {
            while(arr[i] > 0) {
                bw.write(i + "\n");
                arr[i]--;
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
