package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean []primeNum = new boolean[1000001];
		primeNum[1]=true;
		int M=Integer.parseInt(st.nextToken()),N=Integer.parseInt(st.nextToken());
		for(int i=2;i<=(int)Math.sqrt(N)+1;i++) {
			for(int j=2;j<=1000000/i;j++) {
				primeNum[i*j]=true;
			}
		}
		for(int i=M;i<=N;i++) {
			if(!primeNum[i]) System.out.println(i);
		}
	}
}
