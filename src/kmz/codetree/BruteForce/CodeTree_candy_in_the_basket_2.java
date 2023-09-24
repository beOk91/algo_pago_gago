package kmz.codetree.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_candy_in_the_basket_2 {
    /*
     * https://www.codetree.ai/missions/5/problems/candy-in-the-basket-2?&utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int maxNum = 101;

        int[] basketList = new int[maxNum];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int candyNum = Integer.parseInt(st.nextToken());
            int basketNum = Integer.parseInt(st.nextToken());
            sum += candyNum;
            basketList[basketNum] += candyNum;
        }

        if (k * 2 > maxNum) {
            System.out.println(sum);
            return;
        }

        int maxCandy = Integer.MIN_VALUE;
        for (int i = 0; i < maxNum - k * 2; i++) {
            int temp = 0;
            for (int j = i; j <= (i + k * 2); j++) {
                temp += basketList[j];
            }
            maxCandy = Math.max(maxCandy, temp);
        }
        System.out.println(maxCandy);
    }
}
