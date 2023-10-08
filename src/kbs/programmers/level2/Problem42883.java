package kbs.programmers.level2;

import java.util.Stack;

public class Problem42883 {
	public static void main(String[] args) {
		System.out.println(solution("1924",	2));
	}
	
	public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> s = new Stack<Character>();
        for(char c: number.toCharArray()) {
        	while(k>0 && !s.isEmpty() && s.peek()<c) {
        		s.pop(); k--;
        	}
        	s.add(c);
        }
        while(k-->0){
            s.pop();
        }
        while(!s.isEmpty()) {
        	answer.append(s.pop());
        }
        
        return answer.reverse().toString();
    }
}
