package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1654 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K=Integer.parseInt(st.nextToken()),N=Integer.parseInt(st.nextToken());
		long	lanCable[] = new long[K];
		for(int i=0;i<K;i++) {
			lanCable[i]=Long.parseLong(br.readLine());
		}
		Arrays.sort(lanCable);
		
		long start =1;
		long end=lanCable[K-1];
		while(end>=start) {
			long mid=(start+end)/2;
			int cnt=0;
			for(int i=0;i<K;i++) {
				cnt+=lanCable[i]/mid;
			}
			if(cnt>=N) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		System.out.println(end);
	}
}
