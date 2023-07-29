package kjy;

public class _124_나라의숫자_12899 {
    public String solution(int n) {
        int[] dict = {1, 2, 4};

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.append(dict[n % 3]);
            n /= 3;
        }

        return sb.reverse().toString();
    }
}
