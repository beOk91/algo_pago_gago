package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class beakjoon1168 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()		
				);
		int size = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		int[] permutation = new int[size];
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= size; i++) {
			queue.offer(i);
		}

		for (int k = 0; k < size; k++) {
			for (int i = 0; i < time - 1; i++) {
				queue.offer(queue.poll());
			}
			permutation[k] = queue.poll();
		}

		System.out.print("<");
		for (int i = 0; i < permutation.length; i++) {
			System.out.print(permutation[i]);
			if (i == permutation.length - 1) {
				System.out.print(">");
			} else {
				System.out.print(", ");
			}

		}
	}

	}

