package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1003 {
	static int cnt0[]=new int[41];
	static int cnt1[]=new int[41];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(fibonacci_0(N)+" "+fibonacci_1(N));
		}
	}
	public static int fibonacci_0(int n) {
	    if (n == 0) {
	    	cnt0[0]=1; return 1;
	    } else if (n == 1) {
	    	cnt0[1]=0; return 0;
	    } else {
	    	if(cnt0[n]!=0) {
	    		return cnt0[n];
	    	}else {
	    		return cnt0[n]=fibonacci_0(n-1)+fibonacci_0(n-2);
	    	}
	    }
	}
	
	public static int fibonacci_1(int n) {
	    if (n == 0) {
	    	cnt1[0]=0; return 0;
	    } else if (n == 1) {
	    	cnt1[1]=1; return 1;
	    } else {
	    	if(cnt1[n]!=0) {
	    		return cnt1[n];
	    	}else {
	    		return cnt1[n]=fibonacci_1(n-1)+fibonacci_1(n-2);
	    	}
	    }
	}
}
