package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon2579 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int stairCnt = Integer.parseInt(bf.readLine());
		
		int[] stairScore = new int[stairCnt];
		int[] dp = new int [stairCnt];
		for(int i=0;i <stairCnt; i++) {
			stairScore[i] = Integer.parseInt(bf.readLine());
		}
		dp[0] = stairScore[0];
		dp[1] = stairScore[0] + stairScore[1];
		dp[2]= Math.max(stairScore[0], stairScore[1])+ stairScore[2];
		for(int i=3;i<stairCnt;i++) {
			dp[i] = Math.max(dp[i-3]+ stairScore[i-1],dp[i-2]) +stairScore[i];
			
		}
		System.out.println(dp[stairCnt-1]);
		
		

	}

}
