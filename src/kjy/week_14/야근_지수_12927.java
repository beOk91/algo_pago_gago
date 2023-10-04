package kjy.week_14;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근_지수_12927 {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            pq.offer(work);
        }

        for (int i = 0; i < n; i++) {
            int work = pq.poll();

            if (work == 0) {
                break;
            }

            pq.offer(work - 1);
        }

        long answer = 0;

        while(!pq.isEmpty()) {
            int work = pq.poll();
            answer += (long) work * work;
        }

        return answer;
    }
}
