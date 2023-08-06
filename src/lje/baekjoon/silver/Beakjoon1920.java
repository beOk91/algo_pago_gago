package lje.baekjoon.silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beakjoon1920 {
	
	public static void main (String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[] arrN = new int[N];
		StringTokenizer st = null;
		st = new StringTokenizer(bf.readLine());
		
		
		for(int i=0;i<N;i++) {
			arrN[i] = Integer.parseInt(st.nextToken());

		}
		Arrays.sort(arrN);
		
		int M = Integer.parseInt(bf.readLine());
		int[] arrM = new int[M];
		StringTokenizer st2 = null;

		st2 = new StringTokenizer(bf.readLine());

		for(int i=0;i<M;i++) {
			arrM[i] = Integer.parseInt(st2.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			System.out.println(Search(arrN,arrM[i]));
		}
		
	
		
	}
	
	
	public static int Search(int[] arr, int num) {
		int start = 0;
		int end = arr.length -1;
		int mid = 0;
		
		while(start<=end) {
			mid = (start+end)/2;
			if(arr[mid]==num) return 1;
			else if(arr[mid]> num) end =mid-1;
			else if(arr[mid]<num) start = mid+1;
		}
		return 0;
	}

}
