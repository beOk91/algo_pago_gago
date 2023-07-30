
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;

	public class beakjoon1978 {
		public static StringTokenizer st;
		public static int testCase, N;

		public static void main(String args[]) throws IOException {

			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			testCase = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			int cnt = 0;
			for (int t = 0; t < testCase; t++) {
				N = Integer.parseInt(st.nextToken());

				if (checkPrimeNum(N)) {
					cnt++;
				}
			}
			System.out.println(cnt);

		}

		static boolean checkPrimeNum(int num) {
			if (num == 1) {
				return false;
			} else if (num == 2)
				return true;
			else {
				for (int i = 2; i < num; i++) {
					if (num % i == 0)
						return false;
				}
			}
			return true;
		}
	}
