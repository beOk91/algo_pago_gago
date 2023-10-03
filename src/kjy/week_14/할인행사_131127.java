package kjy.week_14;

import java.util.HashMap;
import java.util.Map;

public class 할인행사_131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            boolean available = true;
            for (String key: wantMap.keySet()) {
                if (!wantMap.get(key).equals(discountMap.get(key))) {
                    available = false;
                    break;
                }
            }

            if (available) {
                answer++;
            }
        }

        return answer;
    }
}
