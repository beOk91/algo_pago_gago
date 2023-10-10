package kh.baekjoon.set1.탐색과_정렬_1;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 숫자_카드_10815 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static String[] deck, cards;

    private static Set<Integer> set = new HashSet<>();

    private static void input() throws IOException {
        br.readLine();
        deck = br.readLine().split(" ");
        for (String card : deck) {
            set.add(Integer.parseInt(card));
        }
        br.readLine();
        cards = br.readLine().split(" ");
        for (String card : cards) {
            bw.write(set.contains(Integer.parseInt(card)) ? "1 " : "0 ");
        }
        bw.write("\n");
    }

    private static void solution() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}
