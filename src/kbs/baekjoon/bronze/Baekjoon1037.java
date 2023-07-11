package kbs.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1037 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		int left=1000001,right=2;
		while(st.hasMoreTokens()) {
			int num=Integer.parseInt(st.nextToken());
			left=Math.min(left, num);
			right=Math.max(right, num);
		}
		System.out.println(left*right);
	}
}
