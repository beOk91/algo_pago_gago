package kh.programmers.혼자_놀기의_달인;

import java.util.*;

class Solution {
    boolean[] visit;
    List<Integer> ls = new ArrayList<>();
    public int solution(int[] cards) {
        int answer = 0;
        visit = new boolean[cards.length];

        for (int c : cards) {
            dfs(cards, c, 0);
        }

        Collections.sort(ls, Collections.reverseOrder());

        if (ls.size() < 2) answer = 0;
        else answer = ls.get(0) * ls.get(1);

        return answer;
    }

    public void dfs(int[] cards, int cur, int lev) {
        if (visit[cur - 1]) {
            if (lev > 0) ls.add(lev);
            return;
        }

        visit[cur - 1] = true;

        dfs(cards, cards[cur - 1], lev + 1);
    }


}

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
        int answer = s.solution(cards);

        System.out.println("answer = " + answer);
    }
}
