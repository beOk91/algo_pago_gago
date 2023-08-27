package kjy.week_08;

public class 타겟넘버_43165 {
    private int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    /**
     * dfs
     * @param numbers 주어진 숫자
     * @param target 타겟 넘버
     * @param depth dfs 깊이
     * @param sum 해당 깊이에서의 숫자 합계
     */
    public void dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
        } else {
            dfs(numbers, target, depth + 1, sum + numbers[depth]);
            dfs(numbers, target, depth + 1, sum - numbers[depth]);
        }
    }
}
