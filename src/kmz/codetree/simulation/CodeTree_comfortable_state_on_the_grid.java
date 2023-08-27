package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_comfortable_state_on_the_grid {
    /*
     * https://www.codetree.ai/missions/5/problems/comfortable-state-on-the-grid?&utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            grid[r-1][c-1] = 1;
            int colored = 0;
            for (int j = 0; j < 4; j++) {
                int nr = r - 1 + dx[j];
                int nc = c - 1 + dy[j];
                if (inRange(n, nr, nc) && grid[nr][nc] == 1) {
                    colored++;
                }
            }
            if (colored == 3) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static boolean inRange(int n, int r, int c) {
        if (r >= 0 && c >= 0 && r < n && c < n) {
            return true;
        } else {
            return false;
        }
    }
}
