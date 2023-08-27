package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon14889 {
	
	public static int N, min;
	public static int Max = 21;

	public static int[][] level;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(bf.readLine());
		
		 level = new int[Max][Max];
		
		for (int i = 1; i < N + 1; i++) {
			StringTokenizer	st = new StringTokenizer(bf.readLine());
			for (int j = 1; j < N + 1; j++) {
				level[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[] check = new boolean[N + 1];
		min = Integer.MAX_VALUE;

		doComb(0, 1, check);
		System.out.println(min);
		

	}
	public static int calScore(boolean[] check) {
		int aScore = 0;
		int bScore = 0;
		for (int i = 1; i <= N; i++) {
			if (check[i]) {
				for (int j = 0; j <= N; j++) {
					if (check[j]) {
						aScore += level[i][j];
					}
				}
			} else {
				for (int j = 0; j <= N; j++) {
					if (!check[j]) {
						bScore += level[i][j];
					}

				}

			}
		}
		return Math.abs(aScore - bScore);
	}
	public static void doComb(int index, int target, boolean[] check) {
		if (index == N / 2) {
			int result = calScore(check);
			if (result < min)
				min = result;
			return;
		}
		if (target > N)
			return;
		if (!check[target]) {
			check[target] = true;
			doComb(index + 1, target + 1, check);
			check[target] = false;
			doComb(index, target + 1, check);

		}
	}

}
