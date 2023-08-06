package kjy.week_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 가장큰수_42746 {
    public String solution(int[] numbers) {
        List<String> numberList = new ArrayList<>();

        for (int number: numbers) {
            numberList.add(String.valueOf(number));
        }

        Collections.sort(numberList, (a, b) -> Integer.valueOf(b + a) - Integer.valueOf(a + b));

        // 0이 맨 앞에 있으면 0이 1개 이상인 배열이므로 0으로 반환
        return numberList.get(0).equals("0") ? "0" : String.join("", numberList);
    }
}