package kjy.week_10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class 가장먼노드_49189 {
    public int solution(int n, int[][] edge) {
        int[] visited = new int[n + 1];
        Node[] adj = new Node[n + 1];

        for (int i = 0; i < n + 1; i++) {
            visited[i] = -1;
        }

        for (int[] e: edge) {
            if (adj[e[0]] == null) {
                adj[e[0]] = new Node();
            }

            if (adj[e[1]] == null) {
                adj[e[1]] = new Node();
            }

            adj[e[0]].set.add(e[1]);
            adj[e[1]].set.add(e[0]);
        }

        // BFS : 노드 번호와 거리를 큐에 삽입
        int maxDistance = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{1, maxDistance});

        while (!queue.isEmpty()) {
            int[] value = queue.removeFirst();
            int node = value[0];
            int distance = value[1];

            // 방문하지 않은 노드만
            if (visited[node] == -1) {
                // 최대 거리 확인
                if (maxDistance < distance) {
                    maxDistance = distance;
                }

                // visited 배열에 거리 저장
                visited[node] = distance++;

                for (int v: adj[node].set) {
                    queue.addLast(new int[]{v, distance});
                }
            }
        }

        int answer = 0;
        for (int v: visited) {
            if (v == maxDistance) {
                answer++;
            }
        }
        return answer;
    }
}

class Node {
    public Set<Integer> set;
    
    public Node() {
        this.set = new HashSet<>();
    }
}