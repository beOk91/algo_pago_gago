package kh.programmers.입국심사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long ln = (long) n;
        long end = (long) times[times.length - 1] * n;
        long start = 1;
        long mid = (start + end) / 2;
        while(start < end) {
            mid = (start + end) / 2;
            long processCount = getProcessCount(mid, times);

            if (ln > processCount) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }

        answer = getProcessCount(mid, times) >= n ? mid : mid + 1;
        return answer;
    }

    private long getProcessCount(long point, int[] times) {
        long answer = 0;

        for (int time : times) {
            answer += point / time;
        }

        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 6;
        int[] times = {7, 10};

        s.solution(n, times);
    }
}
