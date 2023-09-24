package kjy.week_12;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기_12981 {
    public int[] solution(int n, String[] words) {
        Set<String> bank = new HashSet<>();
        char last = 0;
        int cur = 0, idx = 0;

        for (String word: words) {
            // 이미 말한 단어이거나 이전 단어의 마지막 글자와 내가 말한 글자의 첫번째 글자가 다른 경우
            if (bank.contains(word) || (last != 0 && last != word.charAt(0))) {
                return new int[]{cur % n + 1, idx / n + 1};
            }

            bank.add(word);
            last = word.charAt(word.length() - 1);
            cur = cur % n + 1;
            idx++;
        }
        return new int[]{0, 0};
    }
}
