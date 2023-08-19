package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_small_marble_movement {
    /*
     * https://www.codetree.ai/missions/5/problems/small-marble-movement?utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        String d = st.nextToken();

        int dirNum = getDir(d.charAt(0));
        for (int i = 0; i < t; i++) {
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum];
            if (!inRange(n, nx, ny)) {
                dirNum = 3 - dirNum;
            } else {
                x = nx;
                y = ny;
            }
        }
        System.out.println((x + 1) + " " + (y + 1));
    }

    private static boolean inRange(int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static int getDir(char a) {
        if (a == 'R') {
            return 0;
        } else if (a == 'D') {
            return 1;
        } else if (a == 'U') {
            return 2;
        } else { // L
            return 3;
        }
    }
}
