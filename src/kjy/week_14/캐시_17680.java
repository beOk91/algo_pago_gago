package kjy.week_14;

import java.util.ArrayDeque;
import java.util.Deque;

public class 캐시_17680 {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int executionTime = 0;
        Deque<String> cache = new ArrayDeque<>();

        for (String city: cities) {
            String c = city.toUpperCase();
            if (cache.remove(c)) {
                executionTime += 1;
            } else {
                executionTime += 5;
                if (cache.size() == cacheSize) {
                    cache.removeFirst();
                }
            }
            cache.addLast(c);
        }

        return executionTime;
    }
}
