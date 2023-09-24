package kjy.week_12;

public class 다음큰숫자_12911 {
    public int solution(int n) {
        int plus = 0;
        while (true) {
            if(Integer.bitCount(n) == Integer.bitCount(n + ++plus)) {
                return n + plus;
            }
        }
    }
}
