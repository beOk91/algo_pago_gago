package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeTree_blocks_num {
    /*
    * https://www.codetree.ai/missions/5/problems/block-stacking-commands2?utm_source=clipboard&utm_medium=text
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] blocks = new int[n + 1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                blocks[j] += 1;
            }
        }
        System.out.println(Arrays.stream(blocks).max().getAsInt());
    }
}
