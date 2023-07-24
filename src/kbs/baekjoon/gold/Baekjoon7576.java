package kbs.baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7576 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M=Integer.parseInt(st.nextToken()),N=Integer.parseInt(st.nextToken());
		int tomatoBox[][]=new int[N][M];
		for(int i=0;i<N;i++) {
			tomatoBox[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		boolean visited[][]=new boolean[N][M];
		
		int[][]d=new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
		Queue<Integer[]> q= new LinkedList<Integer[]>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(tomatoBox[i][j]==1) {q.add(new Integer[] {i,j,0}); visited[i][j]=true;};
			}
		}
		int result=Integer.MIN_VALUE;
		while(!q.isEmpty()) {
			Integer []temp=q.poll();
			int t_y=temp[0];
			int t_x=temp[1];
			int day=temp[2];
			result=Math.max(result, day);
			for(int i=0;i<4;i++) {
				int y=t_y+d[i][0],x=t_x+d[i][1];
				if(x>=0 && x<M && y>=0 && y<N && !visited[y][x]) {
					if(tomatoBox[y][x]==0) q.add(new Integer[] {y,x,day+1});
					visited[y][x]=true;
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j] && tomatoBox[i][j]==0 ) {result=-1; break;};
			}
		}
		System.out.println(result);
	}
}
