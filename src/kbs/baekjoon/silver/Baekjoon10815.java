package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon10815 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N=Integer.parseInt(br.readLine());
		
		int nArr[]=new int[N];
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			nArr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nArr);
		int M=Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int temp=Integer.parseInt(st.nextToken());
			int left=0,right=N-1;
			while(left<=right) {
				int medium = (left+right)/2;
				if(temp==nArr[medium]) break;
				if(temp<nArr[medium]) {
					right=medium-1;
				}else if(temp>nArr[medium]) {
					left=medium+1;
				}
			}
				bw.write(left>right ? "0": (temp==nArr[(left+right)/2] ? "1": "0"));
				if(st.hasMoreTokens()) bw.write(" ");
		}
		bw.flush();
        bw.close();
        br.close();
	}
}