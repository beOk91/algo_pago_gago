package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_moving_from_side_to_side {
    /*
     * https://www.codetree.ai/missions/5/problems/robot-moving-from-side-to-side?utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[1000001];
        int[] b = new int[1000001];

        int location = 0; int a_time = 1; int t; String d;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            d = st.nextToken();

            for (int j = a_time; j < a_time + t; j++) {
                if (d.equals("L")) {
                    location--;
                } else {
                    location++;
                }
                a[j] = location;
            }
            a_time += t;
        }

        location = 0; int b_time = 1; int before = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            d = st.nextToken();

            for (int j = b_time; j < b_time + t; j++) {
                if (d.equals("L")) {
                    location--;
                } else {
                    location++;
                }
                b[j] = location;
            }
            b_time += t;
        }

        int max_time = a_time;
        if (a_time < b_time) {
            max_time = b_time;
            for (int i = a_time; i < b_time; i++) {
                a[i] = a[a_time - 1];
            }
        } else if (b_time < a_time) {
            max_time = a_time;
            for (int i = b_time; i < a_time; i++) {
                b[i] = b[b_time - 1];
            }
        }

        int result = 0;
        for (int i = 1; i < max_time; i++) {
            if (a[i] == b[i] && a[i - 1] != b[i - 1]) {
                result++;
            }
        }
        System.out.println(result);
    }
}
