package lje.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class beakjoon5430 {
	
	public static 	StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayDeque<Integer> deque;
		StringTokenizer st;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		
		
		while(T --> 0) {
			
			String comm =bf.readLine();	// 문제에서 p에 해당하는 명령어
			int n = Integer.parseInt(bf.readLine());
			
			
			st = new StringTokenizer(bf.readLine(), "[],");
			
			deque = new ArrayDeque<Integer>();
			
			for(int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			AC(comm, deque);
		}
		
		System.out.println(sb);
		
	}
	
	public static void AC(String command, ArrayDeque<Integer> deque) {
		
		boolean isRight = true;
		
		for(char cmd : command.toCharArray()) {
			
			if(cmd == 'R') {
				isRight = !isRight;	
				continue;
			}
			
			
			if(isRight) {
				
				if(deque.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
				
			}
			else {
				if(deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}	
			}
		}
		
		
	   sb.append('[');	
		
		if(deque.size() > 0) {	
			
			if(isRight) {	
				
				sb.append(deque.pollFirst());	
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}
			else {	
				sb.append(deque.pollLast());	
					sb.append(',').append(deque.pollLast());
				}
			}
		
		sb.append(']').append('\n');		
	}
	
}
