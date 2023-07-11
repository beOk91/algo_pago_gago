package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon13305 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int nLength[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		long oilPrice[] = Arrays.stream(br.readLine().split(" ")).mapToLong(Integer::parseInt).toArray();
		long minPrice = oilPrice[0];
		long result=0;
		
		for(int i=0;i<N-1;i++) {
			if(minPrice>oilPrice[i]) minPrice=oilPrice[i];
			result+=minPrice*nLength[i];
		}
		System.out.println(result);
	}
}
