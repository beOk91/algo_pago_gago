package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeTree_MaxSamePoint {
    /*
     * https://www.codetree.ai/missions/5/problems/maximum-overlapped-segments?utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] line = new int[200];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) + 100;
            int end = Integer.parseInt(st.nextToken()) + 100;
            for (int j = start; j < end; j++) {
                line[j] += 1;
            }
        }
        System.out.println(Arrays.stream(line).max().getAsInt());
    }
}
