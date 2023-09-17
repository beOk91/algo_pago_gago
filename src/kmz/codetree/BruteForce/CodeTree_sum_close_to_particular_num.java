package kmz.codetree.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_sum_close_to_particular_num {
    /*
     * https://www.codetree.ai/missions/5/problems/sum-close-to-particular-number?&utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int minDifference = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    if (i != j && i != k) {
                        sum += nums[i];
                    }
                }
                int difference = Math.abs(sum - s);
                if (difference < minDifference) {
                    minDifference = difference;
                }
            }
        }
        System.out.println(minDifference);
    }
}
