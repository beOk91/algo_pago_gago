package kbs.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] in = Arrays.stream(br.readLine().split(" ")).mapToLong(Integer::parseInt).toArray();
		System.out.println((in[2]-in[0])%(in[0]-in[1])==0 ? (in[2]-in[0])/(in[0]-in[1])+1 : (in[2]-in[0])/(in[0]-in[1])+2);
	}
}
