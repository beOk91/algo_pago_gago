package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10816 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		int plusN[]=new int[10000001];
		int minusN[]=new int[10000001];
		while(st.hasMoreTokens()) {
			int t=Integer.parseInt(st.nextToken());
			if(t>=0) plusN[t]+=1;
			else {minusN[t*-1]+=1;}
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int t=Integer.parseInt(st.nextToken());
			if(t>=0) sb.append(plusN[t]+" ");
			else {sb.append(minusN[t*-1]+" ");}
		}
		System.out.println(sb.toString());
	}
}
