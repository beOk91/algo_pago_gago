package kmz.codetree.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_ability_of_developer_3 {
    /*
     * https://www.codetree.ai/missions/5/problems/ability-of-developer-3?&utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 6;
        int[] developers = new int[n];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            developers[i] = Integer.parseInt(st.nextToken());
            sum += developers[i];
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int temp1 = 0;
                    temp1 += developers[i];
                    temp1 += developers[j];
                    temp1 += developers[k];
                    int temp2 = sum - temp1;
                    minDiff = Math.min(minDiff, Math.abs(temp1 - temp2));
                }
            }
        }
        System.out.println(minDiff);
    }
}
