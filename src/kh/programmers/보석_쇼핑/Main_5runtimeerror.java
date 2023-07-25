package kh.programmers.보석_쇼핑;

import java.util.*;

class _Solution {

    public int[] solution(String[] gems) {
        int[] answer = {};

        Set<String> allGems = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> basket = new HashMap<>();
        List<int[]> periodList = new ArrayList<>();

        int left = 0;
        int right = 0;

        basket.put(gems[0], 2);
        while(true) {
            if (basket.size() == allGems.size()) {
                periodList.add(new int[] {left + 1, right + 1});
            }

            if (left == gems.length - 1 && right == gems.length - 1) {
                break;
            }

            if ((left == right || basket.size() < allGems.size()) && right < gems.length - 1) {
                if (left == right) {
                    removeCurrent(basket, gems[right]);
                }
                moveRight(basket, gems[right + 1]);
                right++;
            }
            else {
                moveLeft(basket, gems[left]);
                left++;
            }

        }


        periodList.sort(new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] - o1[0] == o2[1] - o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1] - o1[0], o2[1] - o2[0]);
            }
        });

        answer = periodList.get(0);

        return answer;
    }

    private void removeCurrent(Map<String, Integer> basket, String currentGem) {
        if (basket.get(currentGem) == 1) {
            basket.remove(currentGem);
        }
        else {
            basket.replace(currentGem, basket.get(currentGem) - 1);
        }
    }

    private void moveRight(Map<String, Integer> basket, String nextGem) {
        if (basket.get(nextGem) == null) {
            basket.put(nextGem, 1);
        }
        else {
            basket.replace(nextGem, basket.get(nextGem) + 1);
        }
    }

    private void moveLeft(Map<String, Integer> basket, String currentGem) {
        if (basket.get(currentGem) == 1) {
            basket.remove(currentGem);
        }
        else {
            basket.replace(currentGem, basket.get(currentGem) - 1);
        }
    }
}
public class Main_5runtimeerror {
}
