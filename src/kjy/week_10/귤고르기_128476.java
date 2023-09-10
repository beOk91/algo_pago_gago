package kjy.week_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 귤고르기_128476 {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int t: tangerine) {
            dict.put(t, dict.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(dict.keySet());
        Collections.sort(list, (x, y) -> dict.get(y).compareTo(dict.get(x)));

        int answer = 0;
        for (int item: list) {
            if (k <= 0) {
                break;
            }

            answer++;
            k -= dict.get(item);
        }
        
        return answer;
    }
}
