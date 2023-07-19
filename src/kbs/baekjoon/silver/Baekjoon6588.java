package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon6588 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean primeNum[]=new boolean[1000001];
		primeNum[0]=true; primeNum[1]=true;
		for(int i=2;i<Math.sqrt(1000000);i++) {
			for(int j=2;i*j<1000000;j++) {
				primeNum[i*j]=true;
			}
		}
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			int a=1;
			for(a=n-1;a>1;a--) {
				if(!primeNum[a] && !primeNum[n-a]) break;
			}
			if(!primeNum[a] && !primeNum[n-a]) {
				System.out.println(n+" = "+(n-a)+" + "+a);
			}else {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
	}
}
