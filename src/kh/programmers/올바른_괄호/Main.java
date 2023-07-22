package kh.programmers.올바른_괄호;

import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push('(');
            }
            else {
                if (st.isEmpty()) {
                    return false;
                }

                if (st.peek() == '(') {
                    st.pop();
                }
                else {
                    st.push(c);
                }
            }
        }

        return st.isEmpty();
    }
}
public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = "()()";
        boolean solution = sol.solution(s);

        System.out.println("solution = " + solution);
    }
}
