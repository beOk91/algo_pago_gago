package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_snail_alphabet_square {
    /*
     * https://www.codetree.ai/missions/5/problems/snail-alphabet-square?&utm_source=clipboard&utm_medium=text
     */
    static int dir = 0;
    static int x = 0;
    static int y = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][m];
        char alphabet = 1; // A
        grid[x][y] = 65;

        for (int i = 1; i < n * m; i++) {
            while (true) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (inRange(n, m, nx, ny) && grid[nx][ny] == 0) {
                    x = nx; y = ny;
                    grid[x][y] = 65 + (alphabet++) % 26;
                    break;
                } else {
                    dir = (dir + 1) % 4;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print((char)grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean inRange(int n, int m, int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }
}
