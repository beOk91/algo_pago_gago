package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class beakjoon1016 {

	static int n;
	static int[] arr, dp;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());
		arr = new int[n];
		dp = new int[n];
		String[] input = bf.readLine().split(" ");

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(input[i]);

		dp[0] = arr[0];

		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
		}

		Arrays.sort(dp);
		System.out.print(dp[n - 1] + "\n");
	}

}
