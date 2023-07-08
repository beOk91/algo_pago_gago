package kh.programmers.거리두기_확인하기;


class Solution {

    private int[] di = {-1, 0, 1, 0};
    private int[] dj = {0, 1, 0, -1};

    private boolean[][] visit;
    private boolean violation;

    /**
     * n == board 세로 높이
     * m == board 가로 길이
     */
    private int n, m;

    private void check(String[][] room, int i, int j, int cnt) {
        if (cnt > 2) {
            return;
        }
        if (i < 0 || i == n || j < 0 || j == m) {
            return;
        }
        if (room[i][j].equals("X")) {
            return;
        }
        if (visit[i][j]) {
            return;
        }
        if (room[i][j].equals("P") && cnt > 0) {
            violation = true;
            return;
        }

        for (int w = 0; w < 4; w++) {
            visit[i][j] = true;
            check(room, i + di[w], j + dj[w], cnt + 1);
            visit[i][j] = false;
        }
    }

    public int[] solution(String[][] places) {

        n = places.length;
        m = places[0].length;

        int[] answer = new int[n];
        int idx = 0;
        for (int w = 0; w < answer.length; w++) {
            String[] place = places[w];
            String[][] room = new String[n][m];

            for (int i = 0; i < n; i++) {
                String row = place[i];
                for (int j = 0; j < m; j++) {
                    room[i][j] = String.valueOf(row.charAt(j));
                }
            }

            violation = false;
            visit = new boolean[answer.length][answer.length];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (room[i][j].equals("P")) {
                        check(room, i, j, 0);
                    }
                    if (violation) {
                        break;
                    }
                }
                if (violation) {
                    break;
                }
            }

            answer[idx++] = violation ? 0 : 1;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] places = new String[][] {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}
                , {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}
                , {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}
                , {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}
                , {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        int[] solution = s.solution(places);

        System.out.println("solution = " + solution);

    }
}
