package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beakjoon10816 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arrPlus = new int[10000001];
		int[] arrMinus= new int[10000001];
		int num;
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			num = Integer.parseInt(st.nextToken());
			if(num>=0) {
				arrPlus[num]++;
			}else {
				num = num*-1;
				arrMinus[num]++;
			}
		}
		
		int M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			num = Integer.parseInt(st.nextToken());
			if(num>=0) {
				sb.append(arrPlus[num] + " ");
			}else {
				num = num*-1;
				sb.append(arrMinus[num] + " ");
			}
			
		}
		System.out.print(sb);

	}

}
