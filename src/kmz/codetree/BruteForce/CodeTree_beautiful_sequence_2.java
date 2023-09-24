package kmz.codetree.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeTree_beautiful_sequence_2 {
    /*
     * https://www.codetree.ai/missions/5/problems/beautiful-sequence-2?&utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] aList = new int[n];
        int[] bList = new int[101];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            aList[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            bList[num]++;
        }

        int result = 0;
        for (int i = 0; i <= (n - m); i++) {
            int[] tempList = new int[101];
            for (int j = i; j < i + m; j++) {
                tempList[aList[j]]++;
            }
            if (Arrays.equals(tempList, bList)) {
                result++;
            }
        }
        System.out.println(result);
    }
}
