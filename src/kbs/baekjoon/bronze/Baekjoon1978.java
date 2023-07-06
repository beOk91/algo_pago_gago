package kbs.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1978 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean []sosu =new boolean[1001]; sosu[1]=true;
		for(int i=2;i<1001;i++) {
			for(int j=2;j*i<1001;j++) {
				sosu[j*i]=true;
			}
		}
		int N= Integer.parseInt(br.readLine());
		int result=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			if(!sosu[Integer.parseInt(st.nextToken())]) result++;
		}
		System.out.println(result);
		br.close();
	}
}
