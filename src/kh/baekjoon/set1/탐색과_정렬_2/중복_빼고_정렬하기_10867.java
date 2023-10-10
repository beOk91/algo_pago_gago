package kh.baekjoon.set1.탐색과_정렬_2;

import java.io.*;
import java.util.*;

public class 중복_빼고_정렬하기_10867 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static List<Integer> ls = new ArrayList<>();
    private static Set<Integer> set = new HashSet<>();
    private static String[] nums;
    private static void input() throws IOException {
        br.readLine();
        nums = br.readLine().split(" ");

        for (String num : nums) {
            if (!set.contains(Integer.parseInt(num))) {
                ls.add(Integer.parseInt(num));
            }
            set.add(Integer.parseInt(num));
        }
    }

    private static void solution() throws IOException {
        Collections.sort(ls);

        for (int num : ls) {
            bw.write(num + " ");
        }
        bw.write("\n");
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}
