package kjy.week_01;

import java.util.HashMap;
import java.util.Map;

public class 의상_42578 {
    public int solution(String[][] clothes) {
        Map<String, Integer> collections = new HashMap<>();

        // key: 종류, value: 가지수
        for(int i = 0; i < clothes.length; i++) {
            if (collections.containsKey(clothes[i][1])) {
                collections.replace(clothes[i][1], collections.get(clothes[i][1]) + 1);
            } else {
                collections.put(clothes[i][1], 1);
            }
        }

        int available = 1;
        for (String key: collections.keySet()) {
            available *= collections.get(key) + 1;
        }

        // 아무 것도 입지 않는 경우 제외
        return available - 1;
    }
}
