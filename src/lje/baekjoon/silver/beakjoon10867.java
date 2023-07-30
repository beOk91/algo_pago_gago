import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class beakjoon10867 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		int now=0;
		sb.append(arr[0]+  " ");
		now = arr[0];
		for(int i=1;i<N;i++) {
			if(now==arr[i]) {
				continue;
			}else {
				sb.append(arr[i] + " ");
				now = arr[i];
			}
			
		}
		System.out.print(sb);

	}

}
