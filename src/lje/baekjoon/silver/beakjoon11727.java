package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon11727 {

	public static BufferedReader bf;
	public static int N, ans;
	public static int[] d;

	public static void main(String args[]) throws IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());

		d = new int[N + 1];
		d[1] = 1;
		d[0] = 1;

		for (int i = 2; i < N + 1; i++) {
			d[i] = d[i - 2] * 2 + d[i - 1];
			d[i] %= 10007;
		}

		System.out.println(d[N]);

	}
}
