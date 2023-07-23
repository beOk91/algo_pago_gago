package kjy;

import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐_42628 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for (String op: operations) {
            String[] ops = op.split(" ");

            if ("I".equals(ops[0])) {
                minPq.offer(Integer.parseInt(ops[1]));
                maxPq.offer(Integer.parseInt(ops[1]));
            } else {
                if ("1".equals(ops[1])) {
                    minPq.remove(maxPq.poll());
                } else {
                    maxPq.remove(minPq.poll());
                }
            }
        }

        if (minPq.isEmpty() && maxPq.isEmpty()) {
            return answer;
        }

        answer[0] = maxPq.peek();
        answer[1] = minPq.peek();
        return answer;
    }
}
