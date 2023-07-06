package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baekjoon1463 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		int []dp = new int[1000001]; 
		int []visited = new int [1000001];
		Arrays.fill(dp, 1000001);
		int N=Integer.parseInt(br.readLine()); dp[N]=0;
		for(int i=N;i>=1;i--) {
			if(i%3==0) {
				dp[i/3] = visited[i/3]==0 ? dp[i]+1 : Math.min(dp[i]+1,dp[i/3]);
				visited[i/3]=1;
			}
			if(i%2==0) {
				dp[i/2] = visited[i/2]==0 ? dp[i]+1 : Math.min(dp[i]+1,dp[i/2]);
				visited[i/2]=1;
			}
			dp[i-1]= visited[i-1]==0 ? dp[i]+1 : Math.min(dp[i]+1,dp[i-1]);
			visited[i-1] =1 ;
		}
		bw.write(dp[1]+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
