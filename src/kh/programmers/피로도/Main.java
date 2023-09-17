package kh.programmers.피로도;

class Solution {
    boolean[] visit;
    int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;

        // 0 1 2
        // F F F
        visit = new boolean[dungeons.length];

        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0]) {
                dfs(k - dungeons[i][1], dungeons, i, 1);
            }
        }

        return answer;
    }

    public void dfs(int k, int[][] dungeons, int cur, int cnt) {
        if (visit[cur]) return;
        answer = Math.max(cnt, answer);

        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0]) {
                visit[cur] = true;
                dfs(k - dungeons[i][1], dungeons, i, cnt + 1);
                visit[cur] = false;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int answer = s.solution(k, dungeons);

        System.out.println("answer = " + answer);
    }
}
