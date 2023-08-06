package lje.baekjoon.silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class beakjoon1026 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf= new BufferedReader (new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[] arrA = new int[N];
		int[] arrB = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			arrA[i] = Integer.parseInt(st.nextToken()) ;
		}
		 st = new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			arrB[i] = Integer.parseInt(st.nextToken()) ;
		}
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		int sum =0;
		for( int i=0;i<N;i++) {
			sum+=arrA[i] * arrB[N-1-i];
		}
		System.out.println(sum);

	}

}
