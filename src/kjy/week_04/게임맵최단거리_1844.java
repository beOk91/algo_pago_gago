package kjy.week_04;

import java.util.ArrayDeque;
import java.util.Deque;

public class 게임맵최단거리_1844 {
    public int solution(int[][] maps) {
        int x = 0;
        int y = 0;

        int destinationY = maps.length - 1;
        int destinationX = maps[destinationY].length - 1;

        // 좌, 우, 상, 하
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // 방문한 곳은 1
        int[][] visited = new int[maps.length][maps[0].length];
        visited[y][x] = 1;
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();

            for (int[] move: moves) {
                int moveX = cur[0] + move[0];
                int moveY = cur[1] + move[1];

                // 맵 밖으로 나가면 패스
                if (moveX < 0 || moveX >= maps[0].length || moveY < 0 || moveY >= maps.length) {
                    continue;
                }

                // 길이면서 방문하지 않은 곳이면 큐에 삽입
                // 목적지면 경로 길이 반환
                if (maps[moveY][moveX] == 1 && visited[moveY][moveX] == 0) {
                    int length = visited[cur[1]][cur[0]] + 1;
                    if (moveY == destinationY && moveX == destinationX) {
                        return length;
                    }

                    visited[moveY][moveX] =length;
                    queue.add(new int[]{moveX, moveY});
                }
            }
        }

        // 도착 못했으면 -1
        return -1;
    }
}
