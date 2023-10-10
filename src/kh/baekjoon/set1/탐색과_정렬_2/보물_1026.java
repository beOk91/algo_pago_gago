package kh.baekjoon.set1.탐색과_정렬_2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class 보물_1026 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static String[] A, B;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = br.readLine().split(" ");
        B = br.readLine().split(" ");
    }

    private static void solution() throws IOException {
        int answer = 0;
        Arrays.sort(A, (o1, o2) -> {
            Integer o1Val = Integer.parseInt(o1);
            Integer o2Val = Integer.parseInt(o2);
            return o1Val.compareTo(o2Val);
        });
        Arrays.sort(B, (o1, o2) -> {
            Integer o1Val = Integer.parseInt(o1);
            Integer o2Val = Integer.parseInt(o2);
            return o2Val.compareTo(o1Val);
        });

        for (int i = 0; i < N; i++) {
            answer += (Integer.parseInt(A[i]) * Integer.parseInt(B[i]));
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
