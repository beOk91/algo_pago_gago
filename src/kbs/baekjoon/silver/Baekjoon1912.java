package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1912 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int []dp = new int[n]; dp[0]=arr[0];
		int result =Integer.MIN_VALUE;
		for(int i=1;i<n;i++) {
			if(arr[i]+dp[i-1]>arr[i]) {
				dp[i]=arr[i]+dp[i-1];
			}else {
				dp[i]=arr[i];
			}
		}
		for(int i=0;i<n;i++) {
			if(result<dp[i]) result=dp[i];
		}
		System.out.println(result);
	}
}
