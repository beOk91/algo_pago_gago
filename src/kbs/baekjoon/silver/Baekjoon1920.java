package kbs.baekjoon.silver;

import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon1920 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<N;i++) {
			int temp=sc.nextInt();
			map.put(temp, 1);
		}
		int M= sc.nextInt();
		for(int i=0;i<M;i++) {
			int temp=sc.nextInt();
			System.out.println(map.getOrDefault(temp, 0));
		}
	}

}
