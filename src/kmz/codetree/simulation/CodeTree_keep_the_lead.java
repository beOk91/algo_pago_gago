package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_keep_the_lead {
    /*
     * https://www.codetree.ai/missions/5/problems/keep-the-lead?utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[1000001];
        int[] b = new int[1000001];

        int location = 0;
        int time = 1;
        int v;
        int t;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            for (int j = time; j < time + t; j++) {
                location += v;
                a[j] = location;
            }
            time += t;
        }

        location = 0;
        time = 1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            for (int j = time; j < time + t; j++) {
                location += v;
                b[j] = location;
            }
            time += t;
        }

        String first = "";
        int result = 0;
        for (int i = 1; i < time; i++) {
            if (a[i] > b[i]) {
                if (first.equals("b")) {
                    result++;
                }
                first = "a";
            } else if (b[i] > a[i]) {
                if (first.equals("a")) {
                    result++;
                }
                first = "b";
            }
        }
        System.out.println(result);
    }
}
