package kh.baekjoon.set1.탐색과_정렬_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 수_정렬하기2_2751 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static boolean[] arr;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new boolean[2000001];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num + 1000000] = true;
        }
    }

    private static void solution() throws IOException {
        for (int i = 0; i < 2000001; i++) {
            if (arr[i]) {
                bw.write((i - 1000000) + "\n");
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
