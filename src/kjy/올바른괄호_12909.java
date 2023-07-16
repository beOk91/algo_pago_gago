package kjy;

import java.util.ArrayDeque;
import java.util.Deque;

class 올바른괄호_12909 {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            
            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.removeFirst();
            } else {
                stack.addFirst('(');
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}