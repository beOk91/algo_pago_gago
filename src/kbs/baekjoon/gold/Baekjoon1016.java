package kbs.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1016 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] m = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		boolean[] arr = new boolean[(int) (m[1]-m[0]+1)];
		int result = 0;
			for (long j = 2; j <= Math.sqrt(m[1]); j++) {
				for (long k = m[0]/(j*j); k <= m[1] / (j * j); k++) {
					if(j*j*k-m[0]>=0 && !arr[(int) (j*j*k-m[0])]) arr[(int) (j*j*k-m[0])]=true;
				}
			}
			
		for (long i = m[0]; i <= m[1]; i++) {
			if (!arr[((int) (i - m[0]))])
				result++;
		}
		System.out.println(result);
	}
}