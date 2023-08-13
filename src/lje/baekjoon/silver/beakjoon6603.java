package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class beakjoon6603 {
	public static int k = -1;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf= new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st; 
		
		while(k!=0) {
			
			st=new StringTokenizer( bf.readLine());
			k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;
			arr = new int[k];
			int[] ans = new int[6];
   			for(int i=0;i<k;i++) {
   				arr[i] = Integer.parseInt(st.nextToken());
				
			}
			Arrays.sort(arr);
			doCom(ans, k, 6, 0, 0);
			System.out.println();
			
		}
		

	}
	public static void doCom(int[] ans, int n, int r, int index, int target) {
		if(r==0) {
			for(int a :ans) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		if(target==n)
			return;
		ans[index] = arr[target];
		doCom(ans, n, r-1, index+1, target+1);
		doCom(ans, n, r, index, target+1);
		
	}

}
