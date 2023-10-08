package kjy.week_14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축_17684 {
    public int[] solution(String msg) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] alphabetArr = alphabet.split("");
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0 ; i < alphabet.length(); i++) {
            dict.put(alphabetArr[i], i + 1);
        }

        int maxIndex = 27;
        String[] msgArr = msg.split("");
        List<Integer> compression = new ArrayList<>();
        for (int i = 0; i < msg.length(); i++) {
            String w = msgArr[i];
            while (dict.containsKey(w)) {
                if (i + 1 < msg.length() && dict.containsKey(w + msgArr[i + 1])) {
                    w += msgArr[i + 1];
                    i++;
                } else {
                    break;
                }
            }

            compression.add(dict.get(w));
            if (i + 1 < msg.length()) {
                dict.put(w + msgArr[i + 1], maxIndex++);
            }
        }

        int[] answer = new int[compression.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = compression.get(i);
        }

        return answer;
    }
}
