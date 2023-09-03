package kh.programmers.할인_행사;

import java.util.*;

class Solution {
    public Map<String, Integer> map;
    public Map<String, Integer> mapCopy;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        map = new HashMap<>();
        mapCopy = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
            mapCopy.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length; i++) {
            if (checkOneDay(i, want, number, discount)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean checkOneDay(int today, String[] want, int[] number, String[] discount) {
        if (discount.length - today < 10) return false;

        boolean answer = true;

        // check
        for (int i = 0; i < 10; i++) {
            Integer remain = map.get(discount[today + i]);
            if (remain == null || remain == 0) {
                answer = false;
                break;
            }

            map.replace(discount[today + i], remain - 1);
        }

        // reset
        map = new HashMap<>(mapCopy);

        return answer;
    }

}
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 3, 2, 1};
        String[] discount  = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int answer = s.solution(want, number, discount);

        System.out.println("answer = " + answer);
    }
}
