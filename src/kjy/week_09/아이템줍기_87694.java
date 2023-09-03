package kjy.week_09;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 아이템줍기_87694 {
    private final int[][] MOVE = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[102][102];

        // 인접 점과 연결되어 있는지 확인하기 쉽도록 좌표계 두 배 확장
        // 확장된 좌표가 -1이면 두 점이 선으로 이어진 것으로 판단
        List<Rectangle> rectangles = new ArrayList<>();
        for (int[] r: rectangle) {
            int startX = r[0] * 2;
            int startY = r[1] * 2;
            int endX = r[2] * 2;
            int endY = r[3] * 2;

            for (int x = startX; x <= endX; x++) {
                for (int y = startY; y<= endY; y++) {
                    map[y][x] = -1;
                }
            }

            rectangles.add(new Rectangle(startX, startY, endX, endY));
        }

        int cx = characterX * 2;
        int cy = characterY * 2;
        int ix = itemX * 2;
        int iy = itemY * 2;

        // BFS
        map[cy][cx] = 1;
        Deque<Point> queue = new ArrayDeque<>();
        queue.addLast(new Point(cx, cy, map[cy][cx]));

        while (!queue.isEmpty()) {
            Point point = queue.removeFirst();

            // 아이템 발견
            if (point.x == ix && point.y == iy) {
                return point.move / 2;
            }

            for (int[] m: MOVE) {
                int nextX = point.x + m[0];
                int nextY = point.y + m[1];
                
                if (map[nextY][nextX] == -1 && isBoundary(nextX, nextY, rectangles)) {
                    map[nextY][nextX] = point.move + 1;
                    queue.addLast(new Point(nextX, nextY, map[nextY][nextX]));
                }
            }
        }

        return 0;
    }
    
    private boolean isBoundary(int x, int y, List<Rectangle> rectangles) {
        // 모든 직사각형에 대해 내부에 있지 않으면 전체 사각형의 경계에 있는 것으로 판단
        for (Rectangle r: rectangles) {
            if (r.startX < x && r.startY < y && r.endX > x && r.endY > y) {
                return false;
            }
        }
        
        return true;
    }
}

class Rectangle {
    public final int startX;
    public final int startY;
    public final int endX;
    public final int endY;
    
    public Rectangle(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
}

class Point {
    public final int x;
    public final int y;
    public final int move;
    
    public Point(int x, int y, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }
}
