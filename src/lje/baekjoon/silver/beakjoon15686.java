package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class beakjoon15686 {

	public static int N, M;
	public static int ans = Integer.MAX_VALUE;
	public static boolean[] check;
	static List<int[]> home, chicken;

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		home = new ArrayList<>();
        chicken = new ArrayList<>();
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N ; j++) {
			
				switch (Integer.parseInt(st.nextToken())) {
				case 1:
					home.add(new int[] { i, j });
					break;
				case 2:
					chicken.add(new int[] { i, j });
					break;
				}
			}
		}
		
		check = new boolean[chicken.size()];
		comb(-1, 0);

        System.out.println(ans);
		

	}
	
	public static void comb(int index, int cnt) {
		if(cnt ==M) {
			int dist =0;
			 for (int[] h : home) {
	                int tmp = Integer.MAX_VALUE;
	                for (int i = 0; i < check.length; i++) {
	                    if (check[i])
	                        tmp = Math.min(tmp, Math.abs(h[0] - chicken.get(i)[0]) + Math.abs(h[1] - chicken.get(i)[1]));
	                }
	                dist += tmp;
	            }
	            ans = Math.min(ans, dist);
	            return;
	        }

	        for (int i = index + 1; i < check.length; i++) {
	        	check[i] = true;
	            comb(i, cnt + 1);
	            check[i] = false;
	    	
		}
	}
}
