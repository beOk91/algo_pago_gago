package kjy.week_06;

import java.util.Arrays;

public class 구명보트_42885 {
    public int solution(int[] people, int limit) {        
        int answer = 0;
        int start = 0;
        int end = people.length - 1;

        Arrays.sort(people);
        while (start <= end) {
            // 가장 무거운 사람과 같이 탈 수 있는 사람이 있는지 탐색
            if (people[start] + people[end] <= limit) {
                start++;
            }
            end--;
            answer++;
        }

        return answer;
    }
}
