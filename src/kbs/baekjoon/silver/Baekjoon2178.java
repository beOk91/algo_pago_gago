package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon2178 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken()),M=Integer.parseInt(st.nextToken());
		int maze[][]= new int[N][M];
		for(int i=0;i<N;i++) {
			maze[i]=Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		int d[][]=new int[][] {{0, 1},{1, 0},{-1, 0},{0, -1}};
		Queue<Integer[]> q = new LinkedList<Integer[]>();
		int visited[][]= new int[N][M];
		q.add(new Integer[] {0,0}); visited[0][0]=1;
		
		while(q.size()!=0) {
			Integer []d_temp=q.poll();
			for(int i=0;i<d.length;i++) {
				int y=d_temp[0]+d[i][0];
				int x=d_temp[1]+d[i][1];
				if(y>=0 && x>=0 && y<N && x<M) {
					if(maze[y][x]==1 && visited[y][x]==0){
						visited[y][x]=visited[d_temp[0]][d_temp[1]]+1;
						q.add(new Integer[] {y,x});
					}
				}
				
			}
		}
		System.out.println(visited[N-1][M-1]);
	}
}
