package kh.programmers.미로_탈출;

import java.util.*;

class Elem {
    int i;
    int j;
    int count;

    Elem(int i, int j, int count) {
        this.i = i;
        this.j = j;
        this.count = count;
    }
}

class Solution {
    public boolean[][] visit1, visit2;
    public char[][] board;
    public int[] di = {-1, 0, 1, 0};
    public int[] dj = {0, 1, 0, -1};

    public boolean visited = false;
    public int n, m;
    public int lever = Integer.MAX_VALUE;
    public int end = Integer.MAX_VALUE;


    public int solution(String[] maps) {
        int answer = 0;

        n = maps.length;
        m = maps[0].length();

        board = new char[n][m];
        visit1 = new boolean[n][m];
        visit2 = new boolean[n][m];


        int startI = -1;
        int startJ = -1;

        int leverI = -1;
        int leverJ = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = maps[i].charAt(j);
                if (board[i][j] == 'S') {
                    startI = i;
                    startJ = j;
                }

                if (board[i][j] == 'L') {
                    leverI = i;
                    leverJ = j;
                }
            }
        }

        // 1. S -> L
        bfs(startI, startJ, 'L');

        // 2. L -> E
        bfs(leverI, leverJ, 'E');

        return (lever == Integer.MAX_VALUE || end == Integer.MAX_VALUE) ? -1 : lever + end;
    }

    public void bfs(int i, int j, char p) {
        Queue<Elem> q = new LinkedList<>();
        Elem start = new Elem(i, j, 0);

        if (p == 'L') visit1[i][j] = true;
        if (p == 'E') visit2[i][j] = true;

        q.add(start);

        while(!q.isEmpty()) {
            Elem thisPos = q.remove();

            if (board[thisPos.i][thisPos.j] == p) {
                if (p == 'L') lever = thisPos.count;
                if (p == 'E') end = thisPos.count;
                break;
            }

            for (int w = 0; w < 4; w++) {
                if (thisPos.i + di[w] < 0 || thisPos.i + di[w] == n || thisPos.j + dj[w] < 0 || thisPos.j + dj[w] == m) {}
                else if (p == 'L' && visit1[thisPos.i + di[w]][thisPos.j + dj[w]]) {}
                else if (p == 'E' && visit2[thisPos.i + di[w]][thisPos.j + dj[w]]) {}
                else if (board[thisPos.i + di[w]][thisPos.j + dj[w]] == 'X') {}
                else {
                    if (p == 'L') visit1[thisPos.i + di[w]][thisPos.j + dj[w]] = true;
                    if (p == 'E') visit2[thisPos.i + di[w]][thisPos.j + dj[w]] = true;
                    q.add(new Elem(thisPos.i + di[w], thisPos.j + dj[w], thisPos.count + 1));
                }
            }
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        int answer = s.solution(maps);

        System.out.println("answer = " + answer);
    }
}
