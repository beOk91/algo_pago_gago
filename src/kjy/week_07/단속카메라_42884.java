package kjy.week_07;

import java.util.Arrays;

public class 단속카메라_42884 {
    public int solution(int[][] routes) {
        // 나간지점 순으로 정렬
        Arrays.sort(routes, (x, y) -> Integer.compare(x[1], y[1]));

        int answer = 0;
        int camera = 0;
        int cars = routes.length;
        boolean[] checked = new boolean[cars];

        for (int i = 0; i < cars; i++) {
            // 현재 설치된 카메라로 확인되는 차량은 제외
            if (checked[i]) {
                continue;
            }

            camera = routes[i][1];
            answer += 1;

            // 새로 설치된 카메라로 확인되는 차량
            for (int j = i; j < cars; j++) {
                if (routes[j][0] <= camera && camera <= routes[j][1]) {
                    checked[j] = true;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}
