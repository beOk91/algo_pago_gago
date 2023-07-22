package kmz.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer[] array1 = new Integer[n];
        int[] array2 = new int[n];

        for (int i = 0; i < n; i++) {
            array1[i] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array1, Collections.reverseOrder());
        Arrays.sort(array2);
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += array1[i] * array2[i];
        }
        System.out.println(result);
    }
}
