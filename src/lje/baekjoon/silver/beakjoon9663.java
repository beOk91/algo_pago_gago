package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon9663 {
	public static int[] arr;
	public static int N;
	public static int cnt = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new int[N];
		nQueen(0);
		System.out.println(cnt);

	}
	
	public static void nQueen(int dep) {
		if(dep==N) {
			cnt++;
			return;
		}
		for(int i=0;i< N;i++) {
			arr[dep] =i;
			if(isPass(dep)) {
				nQueen(dep+1);
			}
		}
	}
	public static boolean isPass(int col) {
		for(int i=0;i<col;i++) {
			if(arr[col] == arr[i]) {
				return false;
			}
			else if(Math.abs(col-i) ==Math.abs(arr[col] - arr[i])) {
			return false;
			}
		}
		return true;
	}

}
