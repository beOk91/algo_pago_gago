package kjy.week_07;

import java.util.Arrays;

public class 섬연결하기_42861 {
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (x, y) -> Integer.compare(x[2], y[2]));

        int answer = 0;
        int[] visited = new int[n];
        visited[costs[0][0]] = 1;

        while (!visitAll(visited)) {
            for (int[] cost: costs) {
                int from = cost[0];
                int to = cost[1];
                int weight = cost[2];

                // 둘 중 한 곳만 방문한 경우에만 다리를 설치한다.
                // 다리를 설치한 후에는 반복문을 종료해 비용이 낮은 다리부터 다시 탐색한다.
                if ((visited[from] == 1 && visited[to] == 0) || ((visited[from] == 0 && visited[to] == 1))) {
                    visited[from] = 1;
                    visited[to] = 1;
                    answer += weight;
                    break;
                }
            }
        }

        return answer;
    }

    private boolean visitAll(int[] visited) {
        for(int v : visited) {
            if (v == 0) {
                return false;
            }
        }
        return true;
    }
}
