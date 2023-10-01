package kjy.week_13;

/**
 *           1
 *     1           2
 *  1     2     3     4
 * 1 2 / 3 4 / 5 6 / 7 8
 */
public class 예상대진표_12985 {
    public int solution(int n, int a, int b) {
        int answer = 1;
        /**
         * 홀수: x / 2 + 1, 짝수: x / 2
         * -> (x + 1) / 2 : x 에 1 을 더해서 계산하면 몫만 비교할 수 있음
         */
        while ((a + 1) / 2 != (b + 1) / 2) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }
        return answer;
    }
}
