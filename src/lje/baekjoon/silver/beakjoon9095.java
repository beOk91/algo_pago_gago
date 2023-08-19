package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon9095 {

	public static int cnt = 0;
	public static int n = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int testCase = 0; testCase<T; testCase++) {
			n = Integer.parseInt(bf.readLine());
			for(int i=1;i<4;i++) {
				doSum(i);
			}
			System.out.println(cnt);
			cnt=0;
			
		}

	}
	public static void doSum(int sum) {
		if(sum==n) {
			cnt++;
			return;
		}else if(sum>n) {
			return;
		}else {
			for(int i=1;i<4;i++) {
				doSum(sum+i);
			}
		}
	}
	

}
