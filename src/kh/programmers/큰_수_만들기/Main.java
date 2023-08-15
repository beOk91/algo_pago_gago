package kh.programmers.큰_수_만들기;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        char[] numbers = number.toCharArray();
        int numSize = number.length() - k;
        int startIdx = 0;

        for (int i = 0; i < numSize; i++) {
            char maxNum = numbers[startIdx];
            int maxIdx = startIdx;
            for (int j = startIdx; j <= k + i; j++) {
                if (maxNum < numbers[j]) {
                    maxNum = numbers[j];
                    maxIdx = j;
                }
            }
            startIdx = maxIdx + 1;
            answer.append(maxNum);
        }

        return answer.toString();
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String number = "4177252841";
        int k = 4;
        String answer = s.solution(number, k);

        System.out.println("answer = " + answer);
    }
}
