package kh.programmers.등굣길;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }

        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) {
                    continue;
                }

                dp[i][j] += dp[i - 1][j] != -1 ? dp[i - 1][j] : 0;
                dp[i][j] += dp[i][j - 1] != -1 ? dp[i][j - 1] : 0;
                dp[i][j] %= 1000000007;
            }
        }

        return dp[n][m];
    }
}
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}, {3, 1}};

        int solution = s.solution(m, n, puddles);
        System.out.println("solution = " + solution);
    }
}
