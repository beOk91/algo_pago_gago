package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2485 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] n_arr=new int[N];
		int[] n_length=new int[N-1];
		int gcd = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			n_arr[i]=Integer.parseInt(br.readLine());
			if(i>0) {n_length[i-1]=n_arr[i]-n_arr[i-1];}
		}
		gcd=n_length[0];
		for(int i=1;i<N-1;i++) {
			for(int j=Math.min(gcd, n_length[i]);j>=1;j--) {
				if(gcd%j==0 && n_length[i]%j==0) {gcd=j; break;}
			}
		}
		int result=0;
		for(int i=0;i<N-1;i++) {
			result+=n_length[i]/gcd-1;
		}
		System.out.println(result);
	}
}
