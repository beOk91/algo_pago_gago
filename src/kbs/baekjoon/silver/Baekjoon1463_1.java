package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baekjoon1463_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		int []dp = new int[1000001];
		int N=Integer.parseInt(br.readLine());
		for(int i=2;i<=N;i++) {
			dp[i]= dp[i-1]+1;
			if(i%3==0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			if(i%2==0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
		}
		bw.write(dp[N]+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
