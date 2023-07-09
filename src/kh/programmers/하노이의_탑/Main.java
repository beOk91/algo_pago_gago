package kh.programmers.하노이의_탑;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<int[]> answerList;

    public int[][] solution(int n) {
        int[][] answer = {};
        answerList = new ArrayList<>();

        hanoi(n, 1, 2, 3);

        answer = new int[answerList.size()][2];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    private void move(int from, int to) {
        answerList.add(new int[] {from, to});
    }

    private void hanoi(int n, int from, int by, int to) {
        if (n == 0) {
            return;
        }

        hanoi(n - 1, from, to, by);
        move(from, to);
        hanoi(n - 1, by, from, to);
    }
}


public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 3;

        int[][] solution = s.solution(n);

        for (int[] ans : solution) {
            System.out.println("[" + ans[0] + ", " + ans[1] + "]");
        }
    }
}
