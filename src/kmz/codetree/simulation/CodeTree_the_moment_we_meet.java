package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_the_moment_we_meet {
    /*
     * https://www.codetree.ai/missions/5/problems/the-moment-we-meet?utm_source=clipboard&utm_medium=text
     */
    static int[] a = new int[1000001];
    static int[] b = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String direction;
        int totalTime = 0;
        int location = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            direction = st.nextToken();
            int time = Integer.parseInt(st.nextToken());

            if (direction.equals("R")) {
                for (int j = 1; j <= time; j++) {
                    a[totalTime + j] = location + j;
                }
                location += time;
            } else {
                for (int j = 1; j <= time; j++) {
                    a[totalTime + j] = location - j;
                }
                location -= time;
            }
            totalTime += time;
        }

        totalTime = 0; location = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            direction = st.nextToken();
            int time = Integer.parseInt(st.nextToken());

            if (direction.equals("R")) {
                for (int j = 1; j <= time; j++) {
                    b[totalTime + j] = location + j;
                    if (a[totalTime + j] == b[totalTime + j]) {
                        System.out.println(totalTime + j);
                        return;
                    }
                }
                location += time;
            } else {
                for (int j = 1; j <= time; j++) {
                    b[totalTime + j] = location - j;
                    if (a[totalTime + j] == b[totalTime + j]) {
                        System.out.println(totalTime + j);
                        return;
                    }
                }
                location -= time;
            }
            totalTime += time;
        }
        System.out.println(-1);
    }
}
