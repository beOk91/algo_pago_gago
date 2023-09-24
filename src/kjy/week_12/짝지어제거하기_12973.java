package kjy.week_12;

import java.util.ArrayDeque;
import java.util.Deque;

public class 짝지어제거하기_12973 {
    public int solution(String s)
    {
        char[] chars = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();    // stack
        for (char c: chars) {
            if (deque.isEmpty() || c != deque.peekFirst()) {
                deque.addFirst(c);   
            } else {
                deque.removeFirst();
            }
        }
        return deque.isEmpty() ? 1 : 0;
    }
}
