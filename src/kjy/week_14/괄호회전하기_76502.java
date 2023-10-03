package kjy.week_14;

import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호회전하기_76502 {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, s.length()) + s.substring(0, i);
            
            Deque<Character> stack = new ArrayDeque<>();
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                if (stack.isEmpty()) {
                    stack.addFirst(c);
                    continue;
                }

                Character top = stack.getFirst();
                if ((top == '(' && c == ')') ||
                    (top == '{' && c == '}') ||
                    (top == '[' && c == ']')) {
                    stack.removeFirst();
                } else {
                    stack.addFirst(c);
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
