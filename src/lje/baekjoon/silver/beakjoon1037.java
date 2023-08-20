package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beakjoon1037 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		
		int T = Integer.parseInt(bf.readLine());
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		while(T-- > 0) {
	
			int N = Integer.parseInt(st.nextToken());
			max = N > max ? N : max;
			min = N < min ? N : min;
		}
		
		System.out.println(max * min);

   }

}
