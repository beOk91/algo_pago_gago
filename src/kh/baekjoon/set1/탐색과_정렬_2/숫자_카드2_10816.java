package kh.baekjoon.set1.탐색과_정렬_2;

import java.io.*;

public class 숫자_카드2_10816 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static String[] deck, cards;
    private static int[] all = new int[20000001];

    private static void input() throws IOException {
        br.readLine();
        deck = br.readLine().split(" ");
        br.readLine();
        cards = br.readLine().split(" ");
    }

    private static void solution() throws IOException {
        for (String card : deck) {
            all[Integer.parseInt(card) + 10000000]++;
        }

        for (String card : cards) {
            bw.write(all[Integer.parseInt(card) + 10000000] + " ");
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
