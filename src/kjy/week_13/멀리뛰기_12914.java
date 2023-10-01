package kjy.week_13;

public class 멀리뛰기_12914 {
    /**
     * 1) 1  : 1
     * 2) 2  : 11 / 2
     * 3) 3  : 111 / 21 / 12
     * 4) 5  : 1111 / 211 / 121 / 112 / 22
     * 5) 8  : 11111 / 2111 / 1211 / 1121 / 221 / 1112 / 212 / 122
     * 6) 13 : 111111 / 21111 / 12111 / 11211 / 2211 / 11121 / 2121 / 1221 / 11112 / 2112 / 1212 / 1122 / 222
     */
    public long solution(int n) {
        if (n == 1) {
            return 1;
        }

        long[] answer = new long[n + 1];
        answer[1] = 1;
        answer[2] = 2;
        for (int i = 3; i < n; i++) {
            answer[i] = (answer[i - 2] + answer[i - 1]) % 1234567;
        }

        return answer[n];
    }
}
