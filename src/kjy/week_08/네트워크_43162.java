package kjy.week_08;

import java.util.ArrayDeque;
import java.util.Deque;

public class 네트워크_43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[n];
        Deque<int[]> queue = new ArrayDeque<>();

        // 컴퓨터 순회
        for (int i = 0; i < n; i++) {
            // 확인한 컴퓨터는 패스
            if (visited[i] == 1) {
                continue;
            }

            queue.addLast(computers[i]);
            visited[i] = 1;

            while (!queue.isEmpty()) {
                int[] computer = queue.removeFirst();

                // 선택한 컴퓨터와 연결된 컴퓨터 확인
                for (int j = 0; j < n; j++) {
                    // 이전에 확인한 적 없는 컴퓨터면 확인
                    if (visited[j] == 0 && computer[j] == 1) {
                        queue.addLast(computers[j]);
                        visited[j] = 1;
                    }
                }
            }

            answer++;
        }

        return answer;
    }
}