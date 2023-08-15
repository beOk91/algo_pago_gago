package kh.programmers.k진수에서_소수_개수_구하기;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String num = Integer.toString(n, k);
        String[] nums = num.split("0");

        for (String candidate : nums) {
            if (isPrime(candidate)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(String candidate) {
        if (candidate.isBlank()) {
            return false;
        }
        long num = Long.parseLong(candidate);
        if (num == 1) {
            return false;
        }

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 110011;
        int k = 10;

        int answer = s.solution(n, k);
        System.out.println("answer = " + answer);
    }
}
