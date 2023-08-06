package kjy.week_03;

import java.util.PriorityQueue;

public class 더맵게_42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        int answer = 0;
        while (pq.size() > 1 && pq.peek() < K) {
            pq.add(pq.poll() + (pq.poll() * 2));
            answer++;
        }

        return pq.peek() >= K ? answer : -1;
    }
}
