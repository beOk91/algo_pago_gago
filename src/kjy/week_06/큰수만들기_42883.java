package kjy.week_06;

import java.util.ArrayDeque;
import java.util.Deque;

public class 큰수만들기_42883 {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < number.length(); i++) {
            char s = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < s && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(s);
        }

        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for(int i = 0; i < size - k; i++) {
            sb.append(stack.removeLast());
        }

        return sb.toString();
    }
}