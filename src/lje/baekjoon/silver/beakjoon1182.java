package lje.baekjoon.silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beakjoon1182 {
	public static BufferedReader bf;
	public static StringTokenizer st;
	public static int n, s, cnt = 0;
	public static int[] sArr = new int[1000000];

	public static void main(String args[]) throws IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			sArr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < n + 1; i++) {
			doBFS(0, i, n, 0);
		}
		System.out.print(cnt);

	}
	public static void doBFS(int ans, int r, int n, int target) {
		if (r == 0) {
			if (ans == s)
				cnt++;
			return;

		}
		if (target==n)
			return;
		doBFS(ans+sArr[target],r-1,n,target+1);
		doBFS(ans,r,n,target+1);
		

	}

}
