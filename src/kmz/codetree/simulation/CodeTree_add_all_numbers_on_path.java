package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_add_all_numbers_on_path {
    /*
     * https://www.codetree.ai/missions/5/problems/add-all-the-numbers-on-the-path?&utm_source=clipboard&utm_medium=text
     */
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] grid = new int[n][n];
        int x = (n - 1) / 2; int y = (n - 1) / 2;
        int dir = 0;
        char[] comments = br.readLine().toCharArray();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = grid[x][y];

        for (int i = 0; i < t; i++) {
            if (comments[i] == 'R') {
                dir = (dir + 1) % 4;
            } else if (comments[i] == 'L') {
                dir = (dir - 1 + 4) % 4;
            } else {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (inRange(nx, ny)) {
                    x = nx;
                    y = ny;
                    result += grid[x][y];
                }
            }
        }
        System.out.println(result);
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
