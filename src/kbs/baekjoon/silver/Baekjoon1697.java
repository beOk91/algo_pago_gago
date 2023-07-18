package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1697 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		int[] route = new int[100001];
		boolean []visited= new boolean[100001];
		q.add(N);
		visited[N]=true;
		while (q.size() > 0) {
			int temp = q.poll();
			if (temp == T) break;
			if (temp * 2 < 100001 && !visited[temp*2]) {
				q.add(temp * 2); visited[temp*2]=true;
				route[temp * 2] = route[temp] + 1;
			}
			if (temp + 1 < 100001 && !visited[temp+1]) {
				q.add(temp + 1); visited[temp+1]=true;
				route[temp + 1] = route[temp] + 1;
			}
			if (temp - 1 >= 0 && !visited[temp-1]) {
				q.add(temp - 1); visited[temp-1]= true;
				route[temp - 1] = route[temp] + 1;
			}
		}
		System.out.println(route[T]);
	}
}
