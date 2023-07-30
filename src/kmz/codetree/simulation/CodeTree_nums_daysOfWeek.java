package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_nums_daysOfWeek {
    /*
     * 2024년 m1월 d1일이 월요일 이었다면, 2024년 m2월 d2까지 A 요일은 몇 번 등장하는지 구하는 프로그램을 작성해보세요.
     * 단, 2024년은 윤년이기 때문에 2월은 29일까지 있으며, (m2월 d2일)이 (m1월 d1일)보다 앞선 날짜로 주어지는 경우는 없다고 가정해도 좋습니다.
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
