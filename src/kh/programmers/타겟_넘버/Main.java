package kh.programmers.타겟_넘버;


class Solution {

    private int answer;

    public int solution(int[] numbers, int target) {
        answer = 0;

        dfs(numbers, 0,0, target);

        return answer;
    }

    public void dfs(int[] numbers, int idx,int number, int target) {
        if (idx == numbers.length) {
            if (number == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, idx + 1, number + numbers[idx], target);
        dfs(numbers, idx + 1, number - numbers[idx], target);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int answer = s.solution(numbers, target);

        System.out.println("answer = " + answer);
    }
}
