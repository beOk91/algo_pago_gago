package kh.programmers.H_Index;


import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int tmp = Math.min(citations[i], citations.length - i);
            answer = Math.max(tmp, answer);
        }

        return answer;
    }
}
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] citations = {3, 0, 6, 1, 5};
        int solution = s.solution(citations);

        System.out.println("solution = " + solution);
    }
}
