package kjy.week_17;

import java.util.ArrayList;
import java.util.List;

public class 스티커_모으기_2_12971 {
    public int solution(int sticker[]) {
        if (sticker.length == 1) {
            return sticker[0];
        }

        // 첫 번째 스티커 (i = 0) 를 뜯는다. (i = 1, i = sticker.length - 1 사용 불가)
        List<Integer> dp1 = new ArrayList<>();
        dp1.add(sticker[0]);
        dp1.add(sticker[0]);
        for (int i = 2; i < sticker.length - 1; i++) {
            dp1.add(Math.max(dp1.get(i - 1), dp1.get(i - 2) + sticker[i]));
        }

        // 첫 번째 스티커 (i = 0) 를 뜯지 않는다.
        List<Integer> dp2 = new ArrayList<>();
        dp2.add(0);
        dp2.add(sticker[1]);
        for (int i = 2; i < sticker.length; i++) {
            dp2.add(Math.max(dp2.get(i - 1), dp2.get(i - 2) + sticker[i]));
        }

        int answer1 = dp1.get(dp1.size() - 1);
        int answer2 = dp2.get(dp2.size() - 1);
        return answer1 > answer2 ? answer1 : answer2;
    }
}
