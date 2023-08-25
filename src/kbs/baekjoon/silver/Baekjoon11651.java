package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Baekjoon11651 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int [][] arr=new int[N][2];
		for(int i=0;i<N;i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		Arrays.sort(arr, new Comparator<int[]>(){
			@Override
			public int compare(int[]a,int[]b) {
				if(a[1]==b[1]) {
					return a[0]-b[0];
				}else {
					return a[1]-b[1];					
				}
			}
		});
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(arr[i][0]+" "+arr[i][1]+"\n");
		}
		System.out.println(sb.toString());
	}
}
