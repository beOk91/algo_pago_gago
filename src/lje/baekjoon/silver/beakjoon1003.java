package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon1003 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int testCase = 0 ; testCase < T ; testCase++) {
			int now = Integer.parseInt(bf.readLine());
			
			int fibo0 = 1;
			int fibo1 = 0;
		    int fibo1Next = 1;
		    for(int i=0;i<now;i++) {
		    	fibo0 = fibo1;
		    	fibo1 = fibo1Next;
		    	fibo1Next = fibo0 + fibo1;
		    }
		    System.out.println(fibo0 + " "+ fibo1);
		    
		}

	}

}
