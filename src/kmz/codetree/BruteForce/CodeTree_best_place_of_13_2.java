package kmz.codetree.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_best_place_of_13_2 {
    /*
     * https://www.codetree.ai/missions/5/problems/best-place-of-13-2?&utm_source=clipboard&utm_medium=text
     */
    static int n;
    static int[][] grid;
    static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nx = i;
                int ny = j + 2;
                if (inRange(nx, ny)) {
                    int value = check(i, j);
                    for (int k = j + 3; k < n; k++) {
                        ny = k + 2;
                        if (inRange(nx, ny)) {
                            checkMax(value + check(i, k));
                        }
                    }


                    for (int k = i + 1; k < n; k++) {
                        for (int a = j; a < n; a++) {
                            nx = k;
                            ny = a + 2;
                            if (inRange(nx, ny)) {
                                checkMax(value + check(k, a));
                            }
                        }
                    }
                }
            }
        }
        System.out.println(maxValue);
    }

    public static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }

    public static int check(int x, int y) {
        int result = 0;
        for (int j = y; j < y + 3; j++) {
            result += grid[x][j];
        }
        return result;
    }

    public static void checkMax(int value) {
        if (value > maxValue) {
            maxValue = value;
        }
    }
}
