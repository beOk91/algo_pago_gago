package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeTree_snail_start_from_center {
    /*
     * https://www.codetree.ai/missions/5/problems/snail-start-from-center?&utm_source=clipboard&utm_medium=text
     */
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        int[][] result = new int[n][n];
        int dir = 0;
        int moveNum = 1;
        int count = 1;
        int x = (n - 1) / 2;
        int y = (n - 1) / 2;

        while (inRange(x, y)) {
            for (int i = 0; i < moveNum; i++) {
                result[x][y] = count++;
                x += dx[dir];
                y += dy[dir];

                if (!inRange(x, y)) {
                    break;
                }
            }
            dir = (dir + 1) % 4;
            if (dir % 2 == 0) {
                moveNum++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
