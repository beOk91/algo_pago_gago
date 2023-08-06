package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class beakjoon9012 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		for(int i=0;i<N;i++) {
			Stack<Character> stack = new Stack<>();
			String nowStr = bf.readLine();
			
			for(int j=0;j<nowStr.length();j++) {
				char c = nowStr.charAt(j);
				
				if(c=='(') {
					stack.push(c);
				}else if(stack.empty()) {
					System.out.println("NO");
					break;
				}  {
					stack.pop();
				}
				if(j==nowStr.length()-1) {
					if(stack.empty()) {
						System.out.println("YES");
					}else {
						System.out.println("NO");
					}
				}
			}
			
		}

	}

}
