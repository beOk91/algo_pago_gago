package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beakjoon11053 {

	public static void main(String args[]) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] line = new int[n];
		int[] d = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (line[i] > line[j] && d[i] < d[j] + 1)
					d[i] = d[j] + 1;
			}
		}
		int ans = d[0];
		for (int i = 0; i < n; i++) {
			if (ans < d[i]) {
				ans = d[i];
			}
		}
		System.out.println(ans);
	}
}
