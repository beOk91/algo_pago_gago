package kjy.week_14;

public class n2_배열자르기_87390 {
    /**
     * n   1 2 3 4 5 6 7 8 9 1011 12 13 14 15 16 17 18 19 20 21 22 23 24 25
     * i   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
     * --------------------------------------------------------------------
     * 1 : 1
     * 2 : 1 2 2 2
     * 3 : 1 2 3 2 2 3 3 3 3
     * 4 : 1 2 3 4 2 2 3 4 3 3 3  4  4  4  4  4
     * 5 : 1 2 3 4 5 2 2 3 4 5 3  3  3  4  5  4  4  4  4  5  5  5  5  5  5
     */
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for (long i = left; i <= right; i++) {
            long q = i / n;
            long r = i % n;
            answer[(int)(i - left)] = (int) (Math.max(q, r) + 1);
        }

        return answer;
    }
}
