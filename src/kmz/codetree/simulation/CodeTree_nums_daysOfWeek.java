package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_nums_daysOfWeek {
    /*
     * https://www.codetree.ai/missions/5/problems/the-day-of-the-day?utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        String a = br.readLine();
        int[] days = new int[] {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int start = d1; int end = d2;
        for (int i = 1; i < m1; i++) {
            start += days[i];
        }
        for (int i = 1; i < m2; i++) {
            end += days[i];
        }
        for (int i = 0; i < 7; i++) {
            if (day[i].equals(a)) {
                start += i;
                break;
            }
        }
        int result = end - start;
        if (result < 0) {
            System.out.println(0);
        } else {
            System.out.println(result / 7 + 1);
        }
    }
}
