package kmz.codetree.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeTree_escaping_carry_2 {
    /*
     * https://www.codetree.ai/missions/5/problems/escaping-carry-2?&utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = list[i] + list[j] + list[k];
                    if (carryCheck(list[i], list[j], list[k]) && sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }
        System.out.println(maxSum != Integer.MIN_VALUE ? maxSum : -1);
    }

    public static boolean carryCheck(int n1, int n2, int n3) {
        int[] carry_sum = new int[5];
        for (int i = 1; i <= Integer.toString(n1).length(); i++) {
            carry_sum[i - 1] += (n1 / Math.pow(10, i - 1)) % 10;
        }
        for (int i = 1; i <= Integer.toString(n2).length(); i++) {
            carry_sum[i - 1] += (n2 / Math.pow(10, i - 1)) % 10;
        }
        for (int i = 1; i <= Integer.toString(n3).length(); i++) {
            carry_sum[i - 1] += (n3 / Math.pow(10, i - 1)) % 10;
        }
        for (int i = 0; i < carry_sum.length; i++) {
            if (carry_sum[i] > 9) {
                return false;
            }
        }
        return true;
    }
}
