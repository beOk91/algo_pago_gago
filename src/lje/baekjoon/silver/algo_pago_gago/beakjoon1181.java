package algo_pago_gago;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class beakjoon1181 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		String[] arr = new String[N];
		for(int i=0;i<N;i++) {
			arr[i] = bf.readLine();
		}

		
	Arrays.sort(arr, new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			if(o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}else {
				return o1.length() - o2.length();
			}
		}});
	
	for(int i=0;i<N;i++) {
		if(i!=0) {
			if(arr[i].equals(arr[i-1])) {
				continue;
			}
		}
		System.out.println(arr[i]); 
	}
	}
	

}
