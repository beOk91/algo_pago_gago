import java.util.*;

public class Main {
	static int result;
	static int s;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		s = sc.nextInt();
		result = 0;
		
		int[] data = new int[n];
		for (int i=0; i<n; i++)
			data[i] = sc.nextInt();
		
		boolean[] visited = new boolean[n];
		for (int i=1; i<=n; i++) {
			combination(data, visited, 0, i);
		}
		
		System.out.println(result);
	}
	
	static void combination(int[] data, boolean[] visited, int start, int r) {
		if (r == 0) {
			check(data, visited);
			return;
		} else {
			for (int i=start; i<data.length; i++) {
				visited[i] = true;
				combination(data, visited, i+1, r-1);
				visited[i] = false;
			}
		}
	}
	
	static void check(int[] data, boolean[] visited) {
		int sum = 0;
		for (int i=0; i<data.length; i++) {
			if (visited[i] == true) {
				sum += data[i];
			}
		}
		
		if (sum == s)
			result ++;
	}
}