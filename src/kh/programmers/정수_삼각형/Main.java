package kh.programmers.정수_삼각형;

import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        int n = triangle.length;

        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = j - 1 >= 0
                        ? Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]
                        : dp[i - 1][j] + triangle[i][j];
            }
        }
        Arrays.sort(dp[n - 1]);

        return dp[n - 1][n - 1];
    }
}
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        int solution = s.solution(triangle);
        System.out.println("solution = " + solution);
    }
}
