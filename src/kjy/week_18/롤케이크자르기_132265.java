package kjy.week_18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 롤케이크자르기_132265 {
    public int solution(int[] topping) {
        Set<Integer> older = new HashSet<>();
        Map<Integer, Integer> younger = new HashMap<>();

        for (int t: topping) {
            younger.put(t, younger.getOrDefault(t, 0) + 1);
        }

        int answer = 0;
        for (int t: topping) {
            older.add(t);
            int youngers = younger.get(t) - 1;
            younger.replace(t, youngers);

            if (youngers == 0) {
                younger.remove(t);
            }

            if (older.size() == younger.size()) {
                answer++;
            }
        }

        return answer;
    }
}
