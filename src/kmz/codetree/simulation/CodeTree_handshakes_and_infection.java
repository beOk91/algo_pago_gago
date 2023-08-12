package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CodeTree_handshakes_and_infection {
    /*
     * https://www.codetree.ai/missions/5/problems/correlation-between-shaking-hands-and-infectious-diseases2?utm_source=clipboard&utm_medium=text
     */
    public static class Point implements Comparable<Point>{
        int t;
        int x;
        int y;

        public Point(int t, int x, int y) {
            this.t = t;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            return this.t - point.t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        Point[] points = new Point[t];
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            Point point = new Point(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
            points[i] = point;
        }
        Arrays.sort(points);

        Map<Integer, Integer> infection = new HashMap<>();
        infection.put(p, k); // 최초 감염
        for (int i = 0; i < t; i++) {
            int x = points[i].x;
            int y = points[i].y;
            boolean x_infect = false;
            boolean y_infect = false;
            if (infection.containsKey(x) && infection.get(x) > 0) {
                if (!infection.containsKey(y)) {
                    y_infect = true;
                }
                int count = infection.get(x);
                infection.replace(x, --count);
            }
            if (infection.containsKey(y) && infection.get(y) > 0) {
                if (!infection.containsKey(x)) {
                    x_infect = true;
                }
                int count = infection.get(y);
                infection.replace(y, --count);
            }
            if (x_infect) {
                infection.put(x, k);
            }
            if (y_infect) {
                infection.put(y, k);
            }
        }

        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (infection.containsKey(i)) {
                result[i - 1] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i]);
        }
    }
}
