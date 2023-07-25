package kh.programmers.보석_쇼핑;

import java.util.*;

class Solution {

    public int[] solution(String[] gems) {
        Set<String> allGems = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> basket = new HashMap<>();

        int start = 0;
        int end = gems.length - 1;

        int s = 0;
        int e = 0;

        basket.put(gems[0], 1);
        while(s < gems.length) {
            if (basket.size() == allGems.size()) {
                if(e - s < end - start) {
                    start = s;
                    end = e;
                }

                basket.put(gems[s], basket.get(gems[s]) - 1);
                if (basket.get(gems[s]) == 0) {
                    basket.remove(gems[s]);
                }
                s++;
            }
            else if (e < gems.length - 1) {
                e++;
                basket.put(gems[e], basket.getOrDefault(gems[e], 0) + 1);
            }
            else {
                break;
            }
        }

        return new int[] {start + 1, end + 1};
    }
}

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();

        String[] gems = {"A", "A", "B"};
        int[] solution = s.solution(gems);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
