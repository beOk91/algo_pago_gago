package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon1463 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(bf.readLine());
		
		int[] Dp = new int[number+1];
		Dp[0] = Dp[1] = 0;
		for(int i=2;i<=number;i++) {
			Dp[i] = Dp[i-1] + 1;
			if(i%2==0) Dp[i] = Math.min(Dp[i], Dp[i/2]+1);
			if(i%3==0) Dp[i] = Math.min(Dp[i], Dp[i/3]+1);
			
		}
 		System.out.print(Dp[number]);
	

	}

}
