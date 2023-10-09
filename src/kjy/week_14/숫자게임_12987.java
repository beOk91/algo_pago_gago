package kjy.week_14;

import java.util.PriorityQueue;

public class 숫자게임_12987 {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        PriorityQueue<Integer> pqB = new PriorityQueue<>();

        for (int i = 0; i < A.length; i++) {
            pqA.offer(A[i]);
            pqB.offer(B[i]);
        }

        int answer = 0;
        while (!pqB.isEmpty()) {
            int numA = pqA.poll();
            int numB = pqB.poll();

            if (numA < numB) {
                answer++;
                continue;
            }

            while (!pqB.isEmpty()) {
                numB = pqB.poll();

                if (numA < numB) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
