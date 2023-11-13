package kh.baekjoon.set4.그리디_알고리즘_1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class 로프_2217 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static Integer[] nums;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new Integer[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void solution() throws IOException {
        // 1. 내림차순정렬
        Arrays.sort(nums, Comparator.reverseOrder());
        int answer = nums[0];


        for (int i = 1; i < N; i++) {
            answer = Math.max(answer, nums[i] * (i + 1));
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