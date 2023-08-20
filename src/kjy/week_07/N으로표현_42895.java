package kjy.week_07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로표현_42895 {
    public int solution(int N, int number) {
        List<Set<Integer>> steps = new ArrayList<>();

        // 최대 8개
        for (int i = 0; i < 8; i++) {
            Set<Integer> numberSet = new HashSet<>();
            // N이 i번 반복된 숫자
            numberSet.add(Integer.valueOf(String.valueOf(N).repeat(i + 1)));

            // 사칙연산으로 생성된 숫자
            for (int j = 0; j < i; j++) {
                for (int x: steps.get(j)) {
                    for (int y: steps.get(i - (j + 1))) {
                        numberSet.add(x + y);
                        numberSet.add(x - y);
                        numberSet.add(x * y);
                        if (y != 0) {
                            numberSet.add(x / y);
                        }
                    }
                }
            }

            // 존재하면 최솟값 반환
            if (numberSet.contains(number)) {
                return i + 1;
            }

            steps.add(numberSet);
        }

        // 8회 초과
        return -1;
    }
}
