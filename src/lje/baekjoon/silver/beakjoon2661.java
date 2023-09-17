package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon2661 {
	public static int N;

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(bf.readLine());
		 getPermutation("");
		 
		

	}
	
	public static void getPermutation(String str) {
		if(str.length()==N) {
			System.out.println(str);
			System.exit(0);
			return;
		}
		for(int i=1;i<4;i++) {
			if (checkStr(str+i)) getPermutation(str+i);
		}
		
	}
	
	public static boolean checkStr(String str) {
		int length = str.length();
		
		for(int i=1; i<=length/2;i++) {
			if(str.substring(length-i).equals(str.substring(length-i*2, length-i))) return false;
		}
		
		
		return true;
		
	}

}
