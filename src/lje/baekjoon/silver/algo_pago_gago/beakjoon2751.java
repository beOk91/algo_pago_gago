package algo_pago_gago;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class beakjoon2751 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(bf.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i<N;i++) {
			
			list.add(Integer.parseInt(bf.readLine()));

		}
		
		Collections.sort(list);
		for(int value : list) {
			sb.append(value).append('\n');
		}
		System.out.println(sb);
		

	}

}
