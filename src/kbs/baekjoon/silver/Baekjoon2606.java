package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2606 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int M= Integer.parseInt(br.readLine());
		boolean network[][]=new boolean[N][N];
		boolean visited[][]=new boolean[N][N];
		StringTokenizer st;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int c1=Integer.parseInt(st.nextToken()),c2=Integer.parseInt(st.nextToken());
			network[c1-1][c2-1]=true; network[c2-1][c1-1]=true;
		}
		
		q.add(0);
		int result=0;
		
		while(!q.isEmpty()) {
			int c=q.poll();
			for(int i=0;i<N;i++) {
				if(!visited[c][i] && network[c][i] && !visited[0][i]) {
					q.offer(i); result++;
					visited[c][i]=true; visited[i][c]=true; visited[0][i]=true;
				}
			}
		}
		System.out.println(result);
	}
}
