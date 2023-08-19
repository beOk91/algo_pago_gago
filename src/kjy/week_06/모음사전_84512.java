package kjy.week_06;

import java.util.ArrayList;
import java.util.List;

public class 모음사전_84512 {
    List<String> list = new ArrayList<>();
    String[] vowel = {"A", "E", "I", "O", "U"};
    int MAX_DEPTH = 5;

    public int solution(String word) {
        int answer = 0;
        makeList("", 0);
        
        for (int i = 0; i < list.size(); i++) {
            if (word.equals(list.get(i))) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public void makeList(String prefix, int depth) {
        if (depth > MAX_DEPTH) {
            return;
        }

        list.add(prefix);
        for (int i = 0; i < vowel.length; i++) {
            makeList(prefix + vowel[i], depth + 1);
        }
    }
}
