package kh.baekjoon.set1.탐색과_정렬_2;

import java.io.*;
import java.util.*;

public class 단어_정렬_1181 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static List<String> ls = new ArrayList<>();
    private static Set<String> set = new HashSet<>();

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (!set.contains(s)) {
                ls.add(s);
            }
            set.add(s);
        }
    }

    private static void solution() throws IOException {
        ls.sort((o1, o2) -> {
            Integer o1Length = o1.length();
            Integer o2Length = o2.length();
            if (o1Length.equals(o2Length)) {
                return o1.compareTo(o2);
            }
            return o1Length.compareTo(o2Length);
        });

        for (String elem : ls) {
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
