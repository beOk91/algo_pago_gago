package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken()),K=Integer.parseInt(st.nextToken());
		int []a=new int[N];
		for(int i=0;i<N;i++) {
			a[i]=Integer.parseInt(br.readLine());
		}
		int result=0;
		for(int i=N-1;i>=0;i--) {
			result+=K/a[i]; K-=K/a[i]*a[i];
		}
		System.out.println(result);
	}
}
