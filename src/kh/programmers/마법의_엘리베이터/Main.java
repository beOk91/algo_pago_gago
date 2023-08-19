package kh.programmers.마법의_엘리베이터;


import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    public int solution(int storey) {

        // 5 ~ 10
        // if (n > 5) res = Math.min(10 - n, n - 5);
        // else if (n < 5) res = Math.min(5 - n, n);
        // else res = 5;

        String str = String.valueOf(storey);

        dfs(str, str.length() - 1, 0, 0);

        return answer;
    }

    public void dfs(String str, int idx, int digit, int sum) {
        if (idx < 0) {
            answer = Math.min(answer, sum + digit);
            return;
        }
        int n = str.charAt(idx) - '0' + digit;

        // 위로
        dfs(str, idx - 1, 1, sum + 10 - n);

        // 아래로
        dfs(str, idx - 1, 0, sum + n);
    }
}
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int storey = 2554;

        s.solution(storey);
    }
}
