package kmz.codetree.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_taking_a_taxi {
    /*
     * https://www.codetree.ai/missions/5/problems/taking-a-taxi-in-the-middle-of-the-marathon-2?&utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            grid[i][0] = Integer.parseInt(st.nextToken());
            grid[i][1] = Integer.parseInt(st.nextToken());
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            int distance = 0;
            for (int j = 1; j < n; j++) {
                if (j == i) {
                    distance += Math.abs(grid[j + 1][0] - grid[j - 1][0]);
                    distance += Math.abs(grid[j + 1][1] - grid[j - 1][1]);
                } else if (j - 1 != i) {
                    distance += Math.abs(grid[j][0] - grid[j - 1][0]);
                    distance += Math.abs(grid[j][1] - grid[j - 1][1]);
                }
            }
            if (distance < minDistance) {
                minDistance = distance;
            }
        }
        System.out.println(minDistance);
    }
}
