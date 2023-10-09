package kh.programmers.숫자_카드_나누기;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        PriorityQueue<Integer> candidate = new PriorityQueue<>(Comparator.reverseOrder());

        int gcdA = totalGCD(arrayA);
        int gcdB = totalGCD(arrayB);

        if (cantDivideAll(arrayA, gcdB)) {
            candidate.add(gcdB);
        }
        if (cantDivideAll(arrayB, gcdA)) {
            candidate.add(gcdA);
        }

        if (!candidate.isEmpty()) {
            answer = candidate.peek();
        }

        return answer;
    }

    boolean cantDivideAll(int[] array, int num) {
        for (int elem : array) {
            if (elem % num == 0) {
                return false;
            }
        }
        return true;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private int totalGCD(int[] array) {
        int gcd = array.length == 1 ? array[0] : Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            gcd = Math.min(gcd, gcd(array[i], array[i + 1]));
        }
        return gcd;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arrayA = {5};
        int[] arrayB = {8};

        int answer = s.solution(arrayA, arrayB);

        System.out.println("answer = " + answer);
    }
}
