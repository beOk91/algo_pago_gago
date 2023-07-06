package kbs.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon10989 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		int N= Integer.parseInt(br.readLine());
		int []arr_N=new int[10001];
		for(int i=0;i<N;i++) {
			int t = Integer.parseInt(br.readLine());
			arr_N[t]+=1;
		}
		for(int i=1;i<10001;i++) {
			if(arr_N[i]>0) {
				for(int j=0;j<arr_N[i];j++)
					bw.write(i+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
