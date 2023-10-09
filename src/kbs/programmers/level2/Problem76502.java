package kbs.programmers.level2;

import java.util.Stack;

public class Problem76502 {
	public void main(String[] args) {
		solution("[](){}");
	}

	public int solution(String s) {
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			if (isCorrect((s.substring(i, s.length()) + s.substring(0, i)).toCharArray())) {
				answer += 1;
			}
		}
		return answer;
	}

	public boolean isCorrect(char[] s) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length; i++) {
			if (st.isEmpty()) {
				st.add(s[i]);
			} else if (s[i] == '}') {
				if (st.peek() == '{')
					st.pop();
			} else if (s[i] == ']') {
				if (st.peek() == '[')
					st.pop();
			} else if (s[i] == ')') {
				if (st.peek() == '(')
					st.pop();
			} else {
				st.add(s[i]);
			}
		}
		return st.isEmpty() ? true : false;
	}
}
