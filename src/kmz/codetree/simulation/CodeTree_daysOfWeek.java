package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_daysOfWeek {
    /*
     * 2011년 m1월 d1일이 월요일 이었다면, 2011년 m2월 d2은 어떤 요일인지를 구하는 프로그램을 작성해보세요.
     * 2011년은 윤년이 아닌 해이기 때문에 2월은 28일까지 있습니다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        int[] days = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int start = d1; int end = d2;
        for (int i = 1; i < m1; i++) {
            start += days[i];
        }
        for (int i = 1; i < m2; i++) {
            end += days[i];
        }
        int result = end - start;
        if (result < 0) {
            System.out.println(day[7 - (-result % 7)]);
        } else {
            System.out.println(day[result % 7]);
        }
    }
}
