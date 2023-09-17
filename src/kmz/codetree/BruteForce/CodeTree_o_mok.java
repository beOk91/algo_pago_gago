package kmz.codetree.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_o_mok {
    /*
     * https://www.codetree.ai/problems/O-mok?&utm_source=clipboard&utm_medium=text
     */
    static int color = 0;
    static int x; static int y; static int n = 19;
    static int[][] grid = new int[n][n];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    if (check_x(i, j)) {
                        return;
                    }
                    if (check_y(i, j)) {
                        return;
                    }
                    if (check_cross_right(i, j)) {
                        return;
                    }
                    if (check_cross_left(i, j)) {
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    public static boolean check_x(int x, int y) {
        int start = grid[x][y];
        int count = 0;
        // 세로
        for (int i = x + 1; i < x + 5; i++) {
            if (i < n && start == grid[i][y]) {
                count++;
                if (count == 4) {
                    System.out.println(start);
                    System.out.println((i - 1) + " " + (y + 1));
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check_y(int x, int y) {
        int start = grid[x][y];
        int count = 0;
        // 가로
        for (int i = y + 1; i < y + 5; i++) {
            if (i < n && start == grid[x][i]) {
                count++;
                if (count == 4) {
                    System.out.println(start);
                    System.out.println((x + 1) + " " + (i - 1));
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check_cross_right(int x, int y) {
        int start = grid[x][y];
        int count = 0;
        int j = y + 1;
        // 대각선
        for (int i = x + 1; i < x + 5; i++) {
            if (i < n && j < n && start == grid[i][j]) {
                count++;
                if (count == 4) {
                    System.out.println(start);
                    System.out.println((i - 1) + " " + (j - 1));
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    public static boolean check_cross_left(int x, int y) {
        int start = grid[x][y];
        int count = 0;
        int j = y - 1;
        // 대각선
        for (int i = x + 1; i < x + 5; i++) {
            if (i < n && j >= 0 && start == grid[i][j]) {
                count++;
                if (count == 4) {
                    System.out.println(start);
                    System.out.println((i - 1) + " " + (j + 3));
                    return true;
                }
                j--;
            }
        }
        return false;
    }
}
