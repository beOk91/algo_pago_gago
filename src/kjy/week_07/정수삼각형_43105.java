package kjy.week_07;

public class 정수삼각형_43105 {
    class Solution {
        public int solution(int[][] triangle) {
            for (int i = 1; i < triangle.length; i++) {
                // 가장 왼쪽
                triangle[i][0] += triangle[i - 1][0];
                // 중간
                for (int j = 1; j < i; j++) {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
                // 가장 오른쪽
                triangle[i][i] += triangle[i - 1][i - 1];
            }

            int answer = triangle[triangle.length - 1][0];
            for (int i = 1; i < triangle.length; i++) {
                answer = Math.max(answer, triangle[triangle.length - 1][i]);
            }
            return answer;
        }
    }
}
