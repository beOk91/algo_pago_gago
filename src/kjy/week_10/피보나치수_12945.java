package kjy.week_10;

import java.util.HashMap;
import java.util.Map;

public class 피보나치수_12945 {
    private final Map<Integer, Integer> memo = new HashMap<>();

    public int solution(int n) {
        return fibonacci(n);
    }

    public int fibonacci(int n) {
        if (n < 2) {
            return n;
        }

        if (memo.get(n) == null) {
            memo.put(n, (fibonacci(n - 1) + fibonacci(n - 2)) % 1234567);
        }

        return memo.get(n);
    }
}
