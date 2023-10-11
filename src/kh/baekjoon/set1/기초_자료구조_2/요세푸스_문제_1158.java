package kh.baekjoon.set1.기초_자료구조_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 요세푸스_문제_1158 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, K;

    private static void input() throws IOException {
        String[] nums = br.readLine().split(" ");
        N = Integer.parseInt(nums[0]);
        K = Integer.parseInt(nums[1]);
    }

    private static void solution() throws IOException {
        List<Integer> ls = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int pos = 0;

        for (int i = 1; i <= N; i++) {
            ls.add(i);
        }
        bw.write("<");
        while(!ls.isEmpty()) {
            pos += (K - 1);
            pos %= ls.size();

            Integer val = ls.remove(pos);
            bw.write(ls.isEmpty() ? val.toString() : val + ", ");
        }
        bw.write(">");
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}
