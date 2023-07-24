package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon6603 {
	static int[]input;
	static boolean[] chk;
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			input=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if(0 == input[0]) {break;}
			else {
				input = Arrays.copyOfRange(input, 1, input.length);
				chk=new boolean[input.length];
				backtracking(new int[6],0,0);
				System.out.println();
			}
		}
	}
	
	public static void backtracking(int result[],int start,int cntNum) {
		if(cntNum==result.length) {
			for(int i=0;i<result.length;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println(); return;
		}
		
		for(int i=start;i<input.length;i++) {
			if(chk[i]) continue;
			result[cntNum]=input[i]; chk[i]=true;
			backtracking(result,i+1,cntNum+1);
			chk[i]=false;
			
		}
	}
}
