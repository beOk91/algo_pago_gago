package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1182 {
	static int[] list;
	static int S;
	static int result=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N= Integer.parseInt(st.nextToken()); S=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		list=new int[N];
		int i=0;
		while(st.hasMoreTokens()) {
			list[i++]=Integer.parseInt(st.nextToken());
		}
		backtracking(0,0,0);
		System.out.println(result);
		
	}
	
	public static void backtracking(int start, int cnt, int arrSum) {
		if(arrSum==S && cnt!=0) {
			result++;
		}
		for(int i=start;i<list.length;i++) {
			backtracking(i+1,cnt+1,arrSum+list[i]);
		}
	}
}
