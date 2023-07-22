package kmz.baekjoon.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int min = 0;

        for (int i = (Math.min(num1, num2)); i >= 1; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                min = i;
                System.out.println(min);
                break;
            }
        }
        System.out.println((num1 / min) * num2);
    }
}
