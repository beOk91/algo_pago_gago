package kh.programmers.카펫;


class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        // 가로가 1 늘면 -> brown += 2; yellow += 세로 - 2;
        // 세로가 1 늘면 -> brwon += 2; yello += 가로 - 2;
        // 가로 3, 세로 3 이 최소
        // 가로 (5000 / 2) - 2가 최대 값

        for (int garo = 3; garo <= 2498; garo++) {
            for (int sero = 3; sero <= garo; sero++) {
                int curBrown = garo * 2 + sero * 2 - 4;
                int curYellow = garo * sero - curBrown;

                if (curBrown == brown && curYellow == yellow) {
                    answer[0] = garo;
                    answer[1] = sero;
                    break;
                }
            }
        }

        return answer;
    }
}
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int brown = 10;
        int yellow = 2;

        int[] solution = s.solution(brown, yellow);

        System.out.println(solution[0] + ", " + solution[1]);
    }
}
