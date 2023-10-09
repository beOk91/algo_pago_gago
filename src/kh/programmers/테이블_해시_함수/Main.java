package kh.programmers.테이블_해시_함수;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;


        // 2. col 을 기준으로 오름차순 정렬 && if 같으면 첫 번째 컬럼 기준으로 내림차순 정렬
        Arrays.sort(data, (o1, o2) -> {
            Integer o1Val = o1[col - 1];
            Integer o2Val = o2[col - 1];
            if (o1Val.equals(o2Val)) {
                Integer o1First = o1[0];
                Integer o2First = o2[0];
                return o2First.compareTo(o1First);
            }
            return o1Val.compareTo(o2Val);
        });

        answer = S_i(data, row_begin - 1);
        for (int i = row_begin; i <= row_end - 1; i++) {
            answer = answer ^ S_i(data, i);
        }

        // 4. xor

        return answer;
    }

    // 3.
    private int S_i(int[][] data, int i) {
        int answer = 0;

        for (int cell : data[i]) {
            answer += cell % (i + 1);
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;


        int answer = s.solution(data, col, row_begin, row_end);
        System.out.println("answer = " + answer);
    }
}
