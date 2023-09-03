package kmz.codetree.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_gather {
    /*
     * https://www.codetree.ai/missions/5/problems/gather?&utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] distance = new int[n];

        for (int i = 0; i < n; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int total_distance = 0;
            for (int j = 0; j < n; j++) {
                total_distance += Math.abs(j - i) * distance[j];
            }
            minValue = Math.min(minValue, total_distance);
        }
        System.out.println(minValue);
    }
}
