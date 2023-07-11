package kh.programmers.가장_큰_수;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        String[] arr = new String[numbers.length];
        boolean isAllZero = true;

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            Integer num1 = Integer.valueOf(o1 + o2);
            Integer num2 = Integer.valueOf(o2 + o1);
            return num1.compareTo(num2);
        });

        for (int i = arr.length - 1; i >= 0; i--) {
            Integer num = Integer.valueOf(arr[i]);
            if (num != 0) {
                isAllZero = false;
            }
            sb.append(arr[i]);
        }

        return isAllZero ? "0" : sb.toString();
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] numbers = {6, 10, 2};

        String solution = s.solution(numbers);

        System.out.println("solution = " + solution);
    }
}
