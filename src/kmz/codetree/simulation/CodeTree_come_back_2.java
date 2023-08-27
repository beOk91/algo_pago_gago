package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeTree_come_back_2 {
    /*
     * https://www.codetree.ai/missions/5/problems/come-back-2?&utm_source=clipboard&utm_medium=text
     */
    static int x = 0, y = 0;
    static int dir = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        int result = 0;
        char[] list = br.readLine().toCharArray();

        for (char c : list) {
            result++;
            if (c == 'F') {
                if (dir < 0) {
                    System.out.println(dir);
                }
                x += dx[dir];
                y += dy[dir];
                if (x == 0 && y == 0) {
                    System.out.println(result);
                    return;
                }
            } else {
                toDir(c);
            }
        }
        System.out.println(-1);
    }

    private static void toDir(char strDir) {
        if (strDir == 'R') {
            dir = (dir + 1) % 4;
        } else if (strDir == 'L') {
            dir = (dir - 1 + 4) % 4;
        }
    }
}
