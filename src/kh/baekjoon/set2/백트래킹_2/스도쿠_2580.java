package kh.baekjoon.set2.백트래킹_2;

import java.io.*;
import java.util.*;

public class 스도쿠_2580 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static class Pos {
        int i;
        int j;

        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static int[][] board = new int[9][9];
    private static List<Pos> blanks = new ArrayList<>();
    private static boolean success = false;

    private static void input() throws IOException {
        for (int i = 0; i < 9; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                if (board[i][j] == 0) {
                    blanks.add(new Pos(i, j));
                }
            }
        }
    }

    private static List<Integer> getCandidate(int i, int j) {
        Set<Integer> answer = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        // 가로
        for (int dj = 0; dj < 9; dj++) {
            answer.remove(board[i][dj]);
        }

        // 세로
        for (int di = 0; di < 9; di++) {
            answer.remove(board[di][j]);
        }

        // square
        int startI = i - (i % 3);
        int startJ = j - (j % 3);

        for (int di = 0; di < 3; di++) {
            for (int dj = 0; dj < 3; dj++) {
                answer.remove(board[startI + di][startJ + dj]);
            }
        }

        return new ArrayList<>(answer);
    }

    private static boolean canPut(int i, int j, int num) {
        // 가로
        for (int dj = 0; dj < 9; dj++) {
            if (board[i][dj] == 0) {
                continue;
            }
            if (board[i][dj] == num) {
                return false;
            }
        }
        // 세로
        for (int di = 0; di < 9; di++) {
            if (board[di][j] == 0) {
                continue;
            }
            if (board[di][j] == num) {
                return false;
            }
        }

        // square
        int startI = i - (i % 3);
        int startJ = j - (j % 3);

        for (int di = 0; di < 3; di++) {
            for (int dj = 0; dj < 3; dj++) {
                if (board[startI + di][startJ + dj] == 0) {
                    continue;
                }
                if (board[startI + di][startJ + dj] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void solution() throws IOException {
        dfs(0);
    }

    private static void dfs(int idx) throws IOException{
        if (idx == blanks.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(board[i][j] + (j == 8 ? "\n" : " "));
                }
            }
            success = true;
            return;
        }
        if (success) {
            return;
        }

        for (int i = idx; i < blanks.size(); i++) {
            Pos blank = blanks.get(i);
            List<Integer> candidates = getCandidate(blank.i, blank.j);
            if (candidates.isEmpty()) {
                return;
            }
            for (int candidate : candidates) {
                if (canPut(blank.i, blank.j, candidate)) {
                    board[blank.i][blank.j] = candidate;
                    dfs(i + 1);
                    board[blank.i][blank.j] = 0;
                }
            }
            if (board[blank.i][blank.j] == 0) {
                return;
            }
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
