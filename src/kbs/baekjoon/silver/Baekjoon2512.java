package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2512 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int asset []=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		long M=Long.parseLong(br.readLine());
		Arrays.sort(asset);
		long start = 1;
		long end = asset[N-1];
		while(end>=start) {
			long mid = (start+end)/2;
			long assetSum=0;
			for(int i=0;i<N;i++) {
				assetSum += mid>=asset[i] ? asset[i] : mid;
			}
			if(assetSum>M) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		System.out.println(end);
	}
}
