package kjy.week_09;

import java.util.Arrays;

public class 입국심사_43238 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = (long) times[0] * n / times.length;
        long end = (long) times[times.length - 1] * n / times.length;
        
        while (start < end) {
            long mid = (start + end) / 2;
            long people = 0;
            
            for (int time: times) {
                people += mid / time;
            }
            
            if (people < n) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
