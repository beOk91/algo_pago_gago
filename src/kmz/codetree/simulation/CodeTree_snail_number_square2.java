package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_snail_number_square2 {
    /*
     * https://www.codetree.ai/missions/5/problems/snail-number-square-2?&utm_source=clipboard&utm_medium=text
     */
    static int dir = 0;
    static int x = 0;
    static int y = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][m];
        grid[x][y] = 1;

        for (int i = 2; i <= n * m; i++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (inRange(n, m, nx, ny) && grid[nx][ny] == 0) {
                x = nx; y = ny;
            } else {
                dir = (dir + 1) % 4;
                x = x + dx[dir];
                y = y + dy[dir];
            }
            grid[x][y] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean inRange(int n, int m, int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
}
