package kbs.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1=Integer.parseInt(st.nextToken()),num2=Integer.parseInt(st.nextToken());
		int gcd = getGCD(Math.max(num1, num2),Math.min(num1, num2));
		System.out.println(gcd);
		System.out.println(num1/gcd*num2/gcd*gcd);
	}
	public static int getGCD(int num1,int num2) {
		if(num2==0) return num1;
		else {
			return getGCD(num2,num1%num2);
		}
	}
}
