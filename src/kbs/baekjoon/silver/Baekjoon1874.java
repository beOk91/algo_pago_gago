package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int idx = 0;
		ArrayList <Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=n;i++) {
			if(i<=arr[idx]) {sb.append("+\n"); list.add(i);}
			while(list.size()!=0 && arr[idx]<=list.get(list.size()-1)) {
				sb.append("-\n"); list.remove(list.size()-1); idx++;
			}
		}
		System.out.println(list.isEmpty() ? sb.toString() : "NO");
	}
}
