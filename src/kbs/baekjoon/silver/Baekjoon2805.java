package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long tree[] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		Arrays.sort(tree);

		long start = 0;
		long end = tree[(int) (N-1)];

		while (end >= start) {
			long mid = (end + start) / 2;
			long cutTree = 0;
			for (int i = 0; i < N; i++) {
				cutTree += (tree[i] - mid > 0 ? tree[i] - mid : 0);
			}
			if (cutTree >= M) {
				start = mid + 1;
			} else {
				end = mid-1;
			}
		}
		System.out.println(end);
	}
}
