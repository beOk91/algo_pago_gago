package kbs.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2667 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] nArr = new int[N][N];
		for (int i = 0; i < N; i++) {
			nArr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		bfs(nArr);
		
	}
	public static void bfs(int[][]arr) {
		int result=0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean[][]visited = new boolean[arr.length][arr.length];
		int d[][]=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
		Queue<Integer[]> q = new LinkedList<Integer[]>();
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr[i][j]==1 && !visited[i][j]) {
					q.add(new Integer[] {i,j}); visited[i][j]=true;
					while(q.size()>0) {
						Integer temp[]= q.poll();
						result++;
						for(int k=0;k<d.length;k++) {
							int y=temp[0]+d[k][0];
							int x=temp[1]+d[k][1];
							if(y>=0 && y<arr.length && x>=0 && x<arr.length) {
								if(arr[y][x]==1 && !visited[y][x]) {
									q.add(new Integer[] {y,x}); visited[y][x]=true;
								}
							}
						}
					}
				}
				if(result>0) {
					list.add(result);
					result=0;
				}
			}
		}
		list.sort(null);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
