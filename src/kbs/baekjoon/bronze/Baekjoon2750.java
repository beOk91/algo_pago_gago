package kbs.baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int arr[]=new int[N];
		Arrays.fill(arr, -1001);
		for(int i=0;i<N;i++) {
			int a=sc.nextInt();
			for(int j=N-1;j>=0;j--) {
				if(arr[j]<=a) {
					for(int k=0;k<j;k++) {
						arr[k]=arr[k+1];
					}
					arr[j]=a; break;
				}
			}
		}
		for(int i=0;i<N;i++) {
			System.out.println(arr[i]);
		}
	}
}
