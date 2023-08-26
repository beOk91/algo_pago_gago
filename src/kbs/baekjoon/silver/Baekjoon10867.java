package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10867 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			if(i!=0 && arr[i-1]==arr[i]) continue;
			sb.append(arr[i]+" ");
		}
		System.out.println(sb.toString().trim());
	}
}
