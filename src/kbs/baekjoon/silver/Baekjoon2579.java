package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2579 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int stairs[]=new int[T+1];
		int dp[]=new int[T+1];
		for(int i=0;i<T;i++) {
			stairs[i]=Integer.parseInt(br.readLine());
		}
		dp[0]=stairs[0]; dp[1]=stairs[0]+stairs[1];
		if(T>=2) {	
		dp[2]= Math.max(stairs[1]+stairs[2], stairs[0]+stairs[2]);
			for(int i=3;i<T;i++) {
				dp[i]=Math.max(dp[i-2]+stairs[i], dp[i-3]+stairs[i-1]+stairs[i]);
			}
		}
		System.out.println(dp[T-1]);
	}

}
