package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_come_back {
    /*
     * https://www.codetree.ai/missions/5/problems/come-back?utm_source=clipboard&utm_medium=text
     */
    static int x = 0, y = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String strDir = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            int dir = toDir(strDir);

            for (int j = 0; j < count; j++) {
                x += dx[dir];
                y += dy[dir];
                result++;

                if (x == 0 && y == 0) {
                    System.out.println(result);
                    return;
                }
            }
        }

        System.out.println(-1);
    }

    private static int toDir(String strDir) {
        if (strDir.equals("E")) {
            return 0;
        } else if (strDir.equals("S")) {
            return 1;
        } else if (strDir.equals("W")) {
            return 2;
        } else {
            return 3;
        }
    }
}
