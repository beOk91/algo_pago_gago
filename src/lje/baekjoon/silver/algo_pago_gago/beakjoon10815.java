package algo_pago_gago;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class beakjoon10815 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(bf.readLine());
		HashSet<Integer> hashcard = new HashSet<Integer>();

		StringTokenizer st = new StringTokenizer(bf.readLine());
		while (st.hasMoreTokens()) {
			hashcard.add(Integer.parseInt(st.nextToken()));
		}
		int userCardCnt = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());

		StringBuilder sb = new StringBuilder();
		while (st.hasMoreTokens()) {
			if (hashcard.contains(Integer.parseInt(st.nextToken()))) {
				sb.append("1 ");
			} else {
				sb.append("0 ");
			}

		}
		System.out.print(sb);


	}

}
