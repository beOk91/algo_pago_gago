package kjy.week_08;

public class 등굣길_42898 {
    public int solution(int m, int n, int[][] puddles) {
        int[][] field = new int[n + 1][m + 1];
        for (int i = 0; i < puddles.length; i++) {
            field[puddles[i][1]][puddles[i][0]] = -1;
        }

        int[][] visited = new int[n + 1][m + 1];
        visited[0][1] = 1;

        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                if (field[y][x] == -1) {
                    continue;
                }

                visited[y][x] = (visited[y][x - 1] + visited[y - 1][x]) % 1_000_000_007;
            }
        }

        return visited[n][m];
    }
}