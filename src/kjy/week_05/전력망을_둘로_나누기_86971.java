package kjy.week_05;

import java.util.ArrayDeque;
import java.util.Deque;

public class 전력망을_둘로_나누기_86971 {
    public int solution(int n, int[][] wires) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        
        // 그래프 생성
        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            graph[from][to] = true;
            graph[to][from] = true;
        }

        // n개 노드 트리로 분할 시 두 트리의 길이의 차의 최댓값 ((n - 1) - 1)
        int answer = n - 2;
        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            // 트리 분할
            graph[from][to] = false;
            graph[to][from] = false;

            // bfs
            answer = Math.min(answer, bfs(graph, n, from));

            // 트리 복구 - 백트래킹
            graph[from][to] = true;
            graph[to][from] = true;
        }

        return answer;
    }
    
    public int bfs(boolean[][] graph, int n, int start) {
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> queue = new ArrayDeque<Integer>();

        int count = 1;
        visited[start] = true;
        queue.offer(start);
        while(!queue.isEmpty()){
            int temp = queue.poll();

            for (int i = 1; i <= n; i++) {
                // 방문한 노드이거나 연결된 노드가 아니면 패스
                if (visited[i] || !graph[temp][i]) {
                    continue;
                }

                visited[i] = true;
                queue.offer(i);
                count++;
            }
        }

        return Math.abs(n - count * 2);
    }
}
