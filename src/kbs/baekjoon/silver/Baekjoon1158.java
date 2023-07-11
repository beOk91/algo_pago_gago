package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		List <Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=N;i++) {
			list.add(i);
		}
		List <Integer> result = new ArrayList<Integer>();
		int pointer = 0;
		while(result.size()!=N) {
			pointer+=(K-1);
			while(pointer>=list.size()) {
				pointer-=list.size();
			}
			result.add(list.remove(pointer));
		}
		System.out.print("<");
		for(int i=0;i<result.size();i++) {
			System.out.print(result.get(i));
			if(i!=result.size()-1) System.out.print(", ");
		}
		System.out.print(">");
		
	}
}
