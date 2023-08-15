package kh.programmers.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private int[] di = {-1, 0, 1, 0};
    private int[] dj = {0, 1, 0, -1};

    private boolean[][] visit;

    private static class Pos {
        int i;
        int j;
        int cnt;

        Pos(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }

    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        visit = new boolean[n][m];

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, 1));
        visit[0][0] = true;

        while(!q.isEmpty()) {
            Pos thisPos = q.remove();

            if (thisPos.i == n - 1 && thisPos.j == m - 1) {
                answer = thisPos.cnt;
                break;
            }

            for (int w = 0; w < 4; w++) {
                int nextI = thisPos.i + di[w];
                int nextJ = thisPos.j + dj[w];
                if ((nextI < 0 || nextI == maps.length || nextJ < 0 || nextJ == maps[0].length)
                        || maps[nextI][nextJ] == 0
                        || visit[nextI][nextJ]) {
                    continue;
                }
                visit[nextI][nextJ] = true;
                q.add(new Pos(nextI, nextJ, thisPos.cnt + 1));
            }
        }

        return answer;
    }
}
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int answer = s.solution(maps);

        System.out.println("answer = " + answer);
    }
}
