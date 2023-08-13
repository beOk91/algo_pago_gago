package kh.programmers.리코쳇_로봇;


import java.util.*;

class Point {
    int i;
    int j;
    int cnt;

    Point(int i, int j, int cnt) {
        this.i = i;
        this.j = j;
        this.cnt = cnt;
    }
}

class Solution {
    public int[] di = {-1, 0, 1, 0};
    public int[] dj = {0, 1, 0, -1};
    public int goalI = -1;
    public int goalJ = -1;
    public int answer = -1;

    public int startI = -1;
    public int startJ = -1;

    public final String OBSTACLE = "D";
    public final String GOAL = "G";
    public final String ROBOT = "R";

    public boolean[][] visit;
    public String[][] map;

    public int solution(String[] board) {

        map = new String[board.length][board[0].length()];
        visit = new boolean[board.length][board[0].length()];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = String.valueOf(board[i].charAt(j));
                if (map[i][j].equals(GOAL)) {
                    goalI = i;
                    goalJ = j;
                }
                if (map[i][j].equals(ROBOT)) {
                    startI = i;
                    startJ = j;
                }
            }
        }

        bfs();

        return answer;
    }


    public void bfs() {
        Queue<Point> q = new LinkedList<>();

        visit[startI][startJ] = true;
        q.add(new Point(startI, startJ, 0));

        while(!q.isEmpty()) {
            Point thisPoint = q.remove();

            if (map[thisPoint.i][thisPoint.j].equals(GOAL)) {
                answer = thisPoint.cnt;
                return;
            }

            for (int w = 0; w < 4; w++) {
                Point nextPoint = getNextPoint(thisPoint, w);
                if (!visit[nextPoint.i][nextPoint.j]) {
                    visit[nextPoint.i][nextPoint.j] = true;
                    q.add(nextPoint);
                }
            }
        }
    }

    public Point getNextPoint(Point thisPoint, int dir) {
        Point nextPoint = new Point(thisPoint.i, thisPoint.j, thisPoint.cnt + 1);
        while(true) {
            if (nextPoint.i + di[dir] < 0 || nextPoint.i + di[dir] == map.length || nextPoint.j + dj[dir] < 0 || nextPoint.j + dj[dir] == map[0].length) {
                break;
            }
            if (map[nextPoint.i + di[dir]][nextPoint.j + dj[dir]].equals(OBSTACLE)) {
                break;
            }
            nextPoint.i += di[dir];
            nextPoint.j += dj[dir];
        }

        return nextPoint;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        int answer = s.solution(board);

        System.out.println("answer = " + answer);
    }
}
