package kh.baekjoon.set1.탐색과_정렬_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 수_정렬하기_2750 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static List<Integer> ls = new ArrayList<>();

    private static void input() throws IOException {
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(br.readLine()));
        }
    }

    private static void solution() throws IOException {
        Collections.sort(ls);

        for (int elem : ls) {
            bw.write(elem + "\n");
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
