package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Baekjoon1181 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String []arr =new String[N];
		for(int i=0;i<N;i++) {
			arr[i]=br.readLine();
		}
		Arrays.sort(arr,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) {
					return o1.compareTo(o2);
				}else {
					return o1.length()-o2.length();
				}
			}
			
		});
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++) {
			if(i>=1 && arr[i-1].equals(arr[i])) continue;
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb.toString());
	}
}
