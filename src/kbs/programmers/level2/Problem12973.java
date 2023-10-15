package kbs.programmers.level2;

import java.util.Stack;

public class Problem12973 {
	public int solution(String s) {
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < s.length(); i++) {
			String temp = s.charAt(i) + "";
			if (stack.isEmpty()) {
				stack.push(temp);
			} else {
				if (stack.peek().equals(temp)) {
					while (!stack.isEmpty() && stack.peek().equals(temp)) {
						stack.pop();
					}
				}else {
					stack.push(temp);
				}
			}
		}
		return stack.isEmpty() ? 1:0;
	}
}
