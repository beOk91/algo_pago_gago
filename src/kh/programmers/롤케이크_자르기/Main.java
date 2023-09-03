package kh.programmers.롤케이크_자르기;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int left = 0;
        int right = 0;

        boolean[] kinds = new boolean[10001];
        boolean[] leftHave = new boolean[10001];
        int[] rightCnt = new int[10001];

        for (int i = 0; i < topping.length; i++) {
            rightCnt[topping[i]]++;
            if (!kinds[topping[i]]) {
                kinds[topping[i]] = true;
                right++;
            }
        }

        for (int t : topping) {
            rightCnt[t]--;
            if (rightCnt[t] == 0) right--;

            if (!leftHave[t]) {
                leftHave[t] = true;
                left++;
            }

            if (left == right) answer++;

            if (left > right) break;
        }


        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int answer = s.solution(topping);

        System.out.println("answer = " + answer);
    }
}
