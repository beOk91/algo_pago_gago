package kh.programmers.소수_찾기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    private boolean[] isPrime = new boolean[10000000];
    private Set<Integer> primeSet = new HashSet<>();
    private boolean[] using;

    private void findPrime(int n) {
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    private void search(char[] nums, int curCharIdx, String num) {
        if (!primeSet.contains(Integer.parseInt(num)) && isPrime[Integer.parseInt(num)]) {
            primeSet.add(Integer.parseInt(num));
        }

        if (nums.length == num.length()) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!using[i]) {
                using[i] = true;
                search(nums, i, num + nums[i]);
                using[i] = false;
            }
        }
    }

    public int solution(String numbers) {
        int answer = 0;

        // 7자리 수 중 가장 큰 수
        findPrime(9999999);
        char[] nums = numbers.toCharArray();
        using = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            using[i] = true;
            search(nums, i, String.valueOf(nums[i]));
            using[i] = false;
        }

        return primeSet.size();
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        String numbers = "011";

        int solution = s.solution(numbers);
        System.out.println("solution = " + solution);
    }
}
