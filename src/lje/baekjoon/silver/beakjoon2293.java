package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class beakjoon2293 {

	static int n, k;
	static int[] coin, dp;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String[] input = bf.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);

		coin = new int[n];
		dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(bf.readLine());
		}

		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j >= coin[i])
					dp[j] += dp[j - coin[i]];
			}
		}

		System.out.print(dp[k] + "\n");
	}

}
