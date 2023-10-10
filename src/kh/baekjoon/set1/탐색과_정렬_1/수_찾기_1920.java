package kh.baekjoon.set1.탐색과_정렬_1;


import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 수_찾기_1920 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, M;
    private static String[] A, B;
    private static void solution() throws IOException {
        Set<Integer> set = new HashSet<>();

        N = Integer.parseInt(br.readLine());
        A = br.readLine().split(" ");

        for (String a : A) {
            set.add(Integer.parseInt(a));
        }

        M = Integer.parseInt(br.readLine());
        B = br.readLine().split(" ");

        for (String b : B) {
            bw.write(set.contains(Integer.parseInt(b)) ? "1\n" : "0\n");
        }

    }

    public static void main(String[] args) throws IOException {
        solution();

        br.close();

        bw.flush();
        bw.close();
    }
}
