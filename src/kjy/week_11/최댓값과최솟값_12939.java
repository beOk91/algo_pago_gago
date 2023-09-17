package kjy.week_11;

import java.util.Arrays;

public class 최댓값과최솟값_12939 {
    public String solution(String s) {
        String[] numStrs = s.split(" ");
        Arrays.sort(numStrs, (x, y) -> Integer.valueOf(x).compareTo(Integer.valueOf(y)));
        return numStrs[0] + " " + numStrs[numStrs.length - 1];
    }
}
