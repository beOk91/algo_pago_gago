package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class beakjoon1874 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int temp =1;
		boolean err =false;
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < n ; i++) {
			int N = Integer.parseInt(bf.readLine());
			
			for( ; temp <= N ; temp++) {
				stack.push(temp);
				sb.append("+").append("\n");
			}
			
			if(stack.peek()==N) {
				stack.pop();
				sb.append("-").append("\n");
			}else {
				err = true;
			}
		}
		
		if(err)
			System.out.println("NO");
		else
			System.out.println(sb);
		}
	}
