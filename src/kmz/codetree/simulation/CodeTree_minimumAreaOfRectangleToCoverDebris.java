package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_minimumAreaOfRectangleToCoverDebris {
    /*
    * https://www.codetree.ai/problems/minimum-area-of-rectangle-to-cover-debris?utm_source=clipboard&utm_medium=text
    */
    public static void main(String[] args) throws IOException {
        int OFFSET = 1000;
        int size = 1000;
        int[][] area = new int[size + OFFSET][size + OFFSET];
        int x1 = 0; int y1 = 0; int x2 = 0; int y2 = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        x1 = Integer.parseInt(st.nextToken()) + OFFSET;
        y1 = Integer.parseInt(st.nextToken()) + OFFSET;
        x2 = Integer.parseInt(st.nextToken()) + OFFSET;
        y2 = Integer.parseInt(st.nextToken()) + OFFSET;

        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                area[i][j] = 1;
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        x1 = Integer.parseInt(st.nextToken()) + OFFSET;
        y1 = Integer.parseInt(st.nextToken()) + OFFSET;
        x2 = Integer.parseInt(st.nextToken()) + OFFSET;
        y2 = Integer.parseInt(st.nextToken()) + OFFSET;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                area[i][j] = 0;
            }
        }

        int min_x = size + OFFSET; int min_y = size + OFFSET; int max_x = 0; int max_y = 0;
        boolean result = false;
        for (int i = 0; i < size + OFFSET; i++) {
            for (int j = 0; j < size + OFFSET; j++) {
                if (area[i][j] == 1) {
                    min_x = Math.min(min_x, i);
                    min_y = Math.min(min_y, j);
                    max_x = Math.max(max_x, i);
                    max_y = Math.max(max_y, j);
                    result = true;
                }
            }
        }
        if (!result) {
            System.out.println(0);
        } else {
            System.out.println((max_x - min_x + 1) * (max_y - min_y + 1));
        }
    }
}
