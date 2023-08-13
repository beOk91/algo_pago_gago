package kh.programmers.호텔_대실;

class Solution {
    final int IN = 1;
    final int OUT = -1;

    public int solution(String[][] book_time) {
        int answer = 0;
        int free = book_time.length;

        int[] schedule = new int[24 * 60];

        for (String[] time : book_time) {
            schedule[getTimeValue(time[0])]++;
            if (getTimeValue(time[1]) + 10 < 24 * 60) schedule[getTimeValue(time[1]) + 10]--;
        }

        for (int i = 0; i < schedule.length; i++) {
            free -= schedule[i];
            answer = Math.max(answer, book_time.length - free);
        }

        return answer;
    }

    // index 구하기
    public int getTimeValue(String timeStr) {
        String[] time = timeStr.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);

        return (60 * hour) + minute;
    }
}
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        int answer = s.solution(book_time);
        System.out.println("answer = " + answer);
    }
}
