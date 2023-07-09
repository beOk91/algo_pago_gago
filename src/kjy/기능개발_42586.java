package kjy;

import java.util.ArrayList;
import java.util.List;

public class 기능개발_42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        // 시간의 흐름과 진척률은 따로 체크
        int time = 0;
        int p = 0;
        int count = 0;

        while(p < progresses.length) {
            if (progresses[p] + speeds[p] * time >= 100) {
                // 작업이 완료되면 다음 작업을 확인
                // 완료된 작업 수 카운트 증가
                p++;
                count++;
            } else {
                // 작업이 완료되지 않으면 시간 증가
                time++;
                // 완료된 이전 작업(들)이 있을 경우 완료된 작업들을 배포 목록에 추가
                // 카운트 초기화
                if (count > 0) {
                    result.add(count);
                    count = 0;
                }
            }
        }
        // 마지막 작업이 완료된 후 배포 목록 추가
        result.add(count);

        // result.stream().mapToInt(i -> i).toArray(); 보다 이게 더 빠름
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
