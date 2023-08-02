package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_strange_flipping_tiles {
    /*
    * https://www.codetree.ai/missions/5/problems/strange-flipping-tiles?utm_source=clipboard&utm_medium=text
    */
    static int size = 1000 * 100 * 2;
    static int max = size / 2;
    static int min = size / 2;
    static int[] tiles = new int[size];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cur = size / 2;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            int pointer = x;
            if (direction.equals("R")) {
                while (pointer-- > 0) {
                    tiles[cur + pointer] = -1;
                }
                cur += (x - 1);
                max = Math.max(cur, max);
            } else if (direction.equals("L")) {
                int minusPointer = pointer * -1;
                while (minusPointer++ < 0) {
                    tiles[cur + minusPointer] = 1;
                }
                cur -= (x - 1);
                min = Math.min(cur, min);
            }
        }

        int black = 0; int white = 0;
        for (int i = min; i <= max; i++) {
            if (tiles[i] == -1) {
                black++;
            } else if (tiles[i] == 1) {
                white++;
            }
        }
        System.out.println(white + " "  + black);
    }
}
