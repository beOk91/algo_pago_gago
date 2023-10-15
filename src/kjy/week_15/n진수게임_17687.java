package kjy.week_15;

public class n진수게임_17687 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder already = new StringBuilder();
        for (int i = 0; already.length() < t * m; i++) {
            already.append(Integer.toString(i, n));
        }

        StringBuilder answer = new StringBuilder();
        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(already.charAt(i));
        }
        return answer.toString().toUpperCase();
    }
}
