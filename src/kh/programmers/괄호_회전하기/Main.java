package kh.programmers.괄호_회전하기;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] charArray = s.toCharArray();
        int n = s.length();
        Queue<Character> q = new LinkedList<>();

        for (char c : charArray) {
            q.add(c);
        }

        for (int i = 0; i < n; i++) {
            if (isRight(q)) {
                answer++;
            }
            rotate(q);
        }


        return answer;
    }

    private void rotate(Queue<Character> q) {
        Character first = q.remove();
        q.add(first);
    }

    private boolean isRight(Queue<Character> q) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();

        for (Character c : q) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            }
            else {
                if (st.isEmpty()) {
                    return false;
                }
                if ((st.peek() == '(' && c == ')') || (st.peek() == '[' && c == ']') || (st.peek() == '{' && c == '}')) {
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }

        if (!st.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "[](){}"	;

        int solution = sol.solution(s);

        System.out.println("solution = " + solution);
    }
}
