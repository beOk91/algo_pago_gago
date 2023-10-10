package kh.baekjoon.set1.탐색과_정렬_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 좌표_정렬하기2_11651 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;

    static class Pos {
        Integer x;
        Integer y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static List<Pos> ls = new ArrayList<>();
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            ls.add(new Pos(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }
    }

    private static void solution() throws IOException {
        ls.sort((o1, o2) -> {
            if (o1.y.equals(o2.y)) {
                return o1.x.compareTo(o2.x);
            }
            return o1.y.compareTo(o2.y);
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
