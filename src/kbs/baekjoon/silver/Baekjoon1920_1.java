package kbs.baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon1920_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int [N];
		for(int i=0;i<N;i++) {
			A[i]=sc.nextInt();
		}
		int M= sc.nextInt();
		Arrays.sort(A);
		
		for(int i=0;i<M;i++) {
			int temp=sc.nextInt();
			int left=0,right=N-1;
			while(left<=right) {
				int medium = (left+right)/2;
				if(temp==A[medium]) {
					break;
				}else if(temp<A[medium]) {
					right = medium-1;
				}else if(temp>A[medium]) {
					left = medium+1;
				}
			}
			System.out.println(left > right ? 0 : (temp== A[(left+right)/2] ? 1:0));
		}
	}

}
