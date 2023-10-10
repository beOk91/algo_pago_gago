package kh.baekjoon.set1.탐색과_정렬_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 좌표_정렬하기_11650 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Pos {
        Integer x;
        Integer y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N;
    private static List<Pos> ls = new ArrayList<>();

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            ls.add(new Pos(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }
    }

    private static void solution() throws IOException {
        Collections.sort(ls, (o1, o2) -> {
           if (o1.x.equals(o2.x)) {
               return o1.y.compareTo(o2.y);
           }
           return o1.x.compareTo(o2.x);
        });

        for (Pos pos : ls) {
            bw.write(pos.x + " " + pos.y + "\n");
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