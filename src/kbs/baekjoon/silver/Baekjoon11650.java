package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Baekjoon11650 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int [][]arr =new int[N][2];
		for(int i=0;i<N;i++) {
			arr[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		Arrays.sort(arr, new Comparator<int []>() {
			@Override
			public int compare(int []o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o1[1] - o2[1];
				}else {
					return o1[0]-o2[0];
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
