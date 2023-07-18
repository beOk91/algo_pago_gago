package kh.programmers.피보나치_수;

class Solution {
    public int solution(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 1234567;
        }

        return fib[n] % 1234567;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 1000;

        int solution = s.solution(n);
        System.out.println("solution = " + solution);
    }
}
