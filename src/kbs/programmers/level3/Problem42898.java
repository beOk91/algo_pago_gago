package kbs.programmers.level3;

public class Problem42898 {
	public static void main(String[] args) {
		System.out.println(solution(3, 3, new int[][] {{2,2}}));
	}

	public static int solution(int m, int n, int[][] puddles) {
		int dp[][] = new int[n][m];
		for (int i = 0; i < puddles.length; i++) {
			dp[puddles[i][0]-1][puddles[i][1]-1] = -1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dp[i][j] == -1) {
					dp[i][j] = 0;
				} else if (i == 0 && j == 0) {
					dp[i][j] = 1;
				} else if (i == 0) {
					dp[i][j] = dp[i][j - 1];
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = (dp[i - 1][j] + dp[i][j - 1])%1000000007;
				}
			}
		}
		/*for test
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(dp[i][j]+",");
			}
			System.out.println();
		}*/
		return dp[n - 1][m - 1];
	}
}
