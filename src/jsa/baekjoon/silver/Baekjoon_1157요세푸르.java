import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i =1 ; i <= n ; i++) {
			queue.offer(i);
		}
		int cnt = 1;
		int idx = 0;
		int[] josephus = new int[n]; 
		while(!queue.isEmpty()) {
			if(cnt++%k == 0) {
				josephus[idx++] = queue.poll();
			}
			else {
				queue.offer(queue.poll());
			}
		}
		System.out.println(Arrays.toString(josephus).replace("[", "<").replace("]", ">"));
	}

}