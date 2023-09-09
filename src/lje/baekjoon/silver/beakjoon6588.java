package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon6588 {

		public static boolean[] prime = new boolean[10001];
		 
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			
			getPrime();
	 
			int testCase = Integer.parseInt(bf.readLine());	// 테스트케이스
	 
			while (testCase-- > 0) {
				int n = Integer.parseInt(bf.readLine());
				int first_partition = n / 2;
				int second_partition = n / 2;
	 
				while (true) {
					// 두 파티션이 모두 소수일 경우
					if (!prime[first_partition] && !prime[second_partition]) {
						sb.append(first_partition).append(' ').append(second_partition).append('\n');
						break;
					}
					first_partition--;
					second_partition++;
				}
			}
			System.out.print(sb);
		}
	 
		public static void getPrime() {
			prime[0] = prime[1] = true;
	 
			for (int i = 2; i <= Math.sqrt(prime.length); i++) {
				if (prime[i])
					continue;
				for (int j = i * i; j < prime.length; j += i) {
					prime[j] = true;
				}
			}
		}

}
