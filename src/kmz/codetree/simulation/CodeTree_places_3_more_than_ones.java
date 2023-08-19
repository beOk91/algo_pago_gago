package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_places_3_more_than_ones {
    /*
     * https://www.codetree.ai/missions/5/problems/place-more-than-3-ones?utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                if (range(n, i, j + 1) && grid[i][j+1] == 1) {
                    count++;
                }
                if (range(n, i+1, j) && grid[i+1][j] == 1) {
                    count++;
                }
                if (range(n, i, j - 1) && grid[i][j-1] == 1) {
                    count++;
                }
                if (range(n, i - 1, j) && grid[i-1][j] == 1) {
                    count++;
                }
                if (count >= 3) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean range(int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
