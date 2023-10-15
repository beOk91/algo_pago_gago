package kh.baekjoon.set2.백트래킹_1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N_Queen_9663 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, answer;
    private static boolean[][] board;
    private static Set<String> set;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new boolean[N][N];
        set = new HashSet<>();
        answer = 0;
    }

    private static void solution() throws IOException {

        List<Integer> queens = new ArrayList<>();
        dfs(0, queens);
        bw.write(answer + "\n");
    }

    private static void dfs(int i, List<Integer> queens) {
        if (i == N) {
            answer++;
            return;
        }

        for (int dj = 0; dj < N; dj++) {
            if (canPut(i, dj)) {
                queens.add(dj);
                board[i][dj] = true;
                dfs(i + 1, queens);
                board[i][dj] = false;
                queens.remove(queens.size() - 1);
            }
        }
    }

    private static String tuple(List<Integer> queens) {
        StringBuilder sb = new StringBuilder();

        for (int queen : queens) {
            sb.append(queen).append("-");
        }

        return sb.toString();
    }

    private static boolean canPut(int i, int j) {
        return vertical(j) && horizontal(i) && cross(i, j);
    }

    private static boolean vertical(int j) {
        for (int i = 0; i < N; i++) {
            if (board[i][j]) {
                return false;
            }
        }
        return true;
    }

    private static boolean horizontal(int i) {
        for (int j = 0; j < N; j++) {
            if (board[i][j]) {
                return false;
            }
        }
        return true;
    }

    private static boolean cross(int i, int j) {
        int pos = 0;
        while(true) {
            if (i + pos >= N && j + pos >= N && i - pos < 0 && j - pos < 0) {
                break;
            }
            if ((i + pos < N && j + pos < N) && board[i + pos][j + pos]) {
                return false;
            }
            if ((i - pos >= 0 && j - pos >= 0) && board[i - pos][j - pos]) {
                return false;
            }
            if ((i + pos < N && j - pos >= 0) && board[i + pos][j - pos]) {
                return false;
            }
            if ((i - pos >= 0 && j + pos < N) && board[i - pos][j + pos]) {
                return false;
            }
            pos++;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}