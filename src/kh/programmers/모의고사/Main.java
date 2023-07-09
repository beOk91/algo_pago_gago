package kh.programmers.모의고사;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[][] man = {{}, {1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int[] solved = new int[4];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < answers.length; i++) {
            for (int j = 1; j <= 3; j++) {
                if (man[j][i % man[j].length] == answers[i]) {
                    solved[j]++;
                }
                max = Math.max(max, solved[j]);
            }
        }

        for (int i = 1; i <= 3; i++) {
            if (max == solved[i]) {
                answer.add(i);
            }
        }

        Collections.sort(answer);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] answers = {1, 3, 2, 4, 2};
        int[] solution = s.solution(answers);

        for (int so : solution) {
            System.out.println(so);
        }
    }
}
