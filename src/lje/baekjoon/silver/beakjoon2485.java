package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon2485 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[] arr1 = new int[N];
		for(int i=0;i<N;i++) {
			arr1[i] = Integer.parseInt(bf.readLine());
		}
		int[] arr2 = new int[N-1];
		int index = 0;
		for(int i=1;i<N;i++) {
			arr2[index++]=arr1[i] - arr1[i-1]; 
			
		}
	
		int LCM = gcd(arr2);
		
		int ans = (((arr1[N-1] - arr1[0])) / LCM) - N + 1;
	

		System.out.println(ans);


	}
	
	public static int gcd(int[] arr) {
	    int result = arr[0];
	    for (int i = 1; i < arr.length; i++) {
	        result = gcd(result, arr[i]);
	    }
	    return result;
	}

	public static int gcd(int a, int b) {
	    if (b == 0) return a;
	    return gcd(b, a % b);
	}

}
