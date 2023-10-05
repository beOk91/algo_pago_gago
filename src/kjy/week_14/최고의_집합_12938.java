package kjy.week_14;

public class 최고의_집합_12938 {
    public int[] solution(int n, int s) {
        int q = s / n;
        int r = s % n;

        if (q == 0) {
            return new int[]{-1};
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = q;
        }

        for (int i = 0; i < r; i++) {
            answer[n - 1 - i]++;
        }

        return answer;
    }
}
