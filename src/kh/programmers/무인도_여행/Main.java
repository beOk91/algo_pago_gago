package kh.programmers.무인도_여행;

import java.util.*;

class Solution {
    private int[] di = {-1, 0, 1, 0};
    private int[] dj = {0, 1, 0, -1};

    private boolean[] visit, complete;

    private int num;

    public int[] solution(String[] maps) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[] answer = {};
        int n = maps[0].length();
        visit = new boolean[n * maps.length];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i * n + j] && maps[i].charAt(j) != 'X') {
                    num = 0;
                    dfs(i, j, maps);
                    pq.add(num);
                }
            }
        }

        if (pq.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        }
        else {
            answer = new int[pq.size()];
            int idx = 0;
            while (!pq.isEmpty()) {
                answer[idx++] = pq.remove();
            }
        }

        return answer;
    }

    public int getPos(int i, int j, int n) {
        return i * n + j;
    }

    public void dfs(int i, int j, String[] maps) {
        if (i < 0 || i == maps.length || j < 0 || j == maps[0].length()) return;
        if (visit[i * maps[0].length() + j]) return;
        if (maps[i].charAt(j) == 'X') return;

        visit[i * maps[0].length() + j] = true;
        num += maps[i].charAt(j) - '0';

        for (int w = 0; w < 4; w++) {
            dfs(i + di[w], j + dj[w], maps);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        int[] answer = s.solution(maps);

        System.out.println("answer = " + answer);
    }
}
