package kmz.baekjoon.silver.dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1037 {
    public static void main(String[] args) throws IOException {
        // BOJ_1037 약수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer> list = new ArrayList<>();
        if (n == 1) {
            int num = Integer.parseInt(st.nextToken());
            System.out.println(num * num);
            return;
        }
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int result = list.get(0) * list.get(n - 1);
        System.out.println(result);
    }
}
