package algo_pago_gago;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class beakjoon10989 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[10001];
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i<N;i++) {
			
			arr[Integer.parseInt(bf.readLine())]++;

		}
		bf.close();
		
		for(int i=0;i<10001;i++) {
			while(arr[i]>0) {
				sb.append(i).append('\n');
				arr[i]--;
			}
		}
		System.out.println(sb);
		

	}

}
