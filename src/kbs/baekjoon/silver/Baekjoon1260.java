package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon1260{
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int V=Integer.parseInt(st.nextToken());
		boolean graph[][]=new boolean[N][N];
		for(int i=0;i<N;i++) {
			graph[i][i]=true;
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v1=Integer.parseInt(st.nextToken()),v2=Integer.parseInt(st.nextToken());
			graph[v1-1][v2-1]=true; graph[v2-1][v1-1]=true;
		}
		visited = new boolean[N];
		
		dfs(graph,V); //1 2 4 3
		
		System.out.println();
		visited = new boolean[N];
		bfs(graph,V);
	}
	public static void dfs(boolean graph[][], int v) {
		System.out.print(v+ " ");
		visited[v-1]=true;
		for(int i=0;i<graph.length;i++) {
			if(graph[v-1][i] && !visited[i]) {
				dfs(graph, i+1);
			}
		}
	}
	public static void bfs(boolean graph[][], int v) {
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(v);	visited[v-1]=true;
		while(queue.size()>0) {
			int t =queue.poll();
			System.out.print(t+" ");
			for(int i=0;i<graph.length;i++) {
				if(graph[t-1][i] && !visited[i]) {
					queue.add(i+1);
					visited[i]=true;
				}
			}
		}

	}
}
