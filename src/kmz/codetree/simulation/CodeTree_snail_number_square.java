package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_snail_number_square {
    /*
     * https://www.codetree.ai/missions/5/problems/snail-number-square?utm_source=clipboard&utm_medium=text
     */
    static int x = 0, y = 0;
    static int dirNum = 0; // 0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int grid[][] = new int[n][m];
        grid[x][y] = 1;

        for (int i = 2; i <= n * m; i++) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];

            if (!inRange(n, m, nx, ny) || grid[nx][ny] != 0) {
                dirNum = (dirNum + 1) % 4;
            }
            x += dx[dirNum];
            y += dy[dirNum];
            grid[x][y] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean inRange(int n, int m, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
