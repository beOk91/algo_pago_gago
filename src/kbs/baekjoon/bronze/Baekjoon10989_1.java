package kbs.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baekjoon10989_1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(System.out));
		int N= Integer.parseInt(br.readLine());
		int []arr_N=new int[N];
		for(int i=0;i<N;i++) {
			arr_N[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N-i;j++) {
				if(arr_N[i]>arr_N[i+j]) {
					int temp = arr_N[i];
					arr_N[i]= arr_N[i+j];
					arr_N[i+j] = temp;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			bw.write(arr_N[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
