package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9095 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int [] dp = new int[12]; dp[1]=1; dp[2]=2; dp[3]=4; dp[4]=7;
		
		for(int i=5;i<12;i++) {
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		}
		for(int i=0;i<T;i++) {
			int t=Integer.parseInt(br.readLine());
			System.out.println(dp[t]);
		}
	}
}
