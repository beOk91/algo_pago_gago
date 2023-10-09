package kh.programmers.점_찍기;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        int[] vertical = new int[d + 1];

        /**
         * 첫 번째 세로 라인 갯수 카운트
         */
        int count = 1;
        for (int i = 0; i * k <= d; i++) {
            vertical[i * k] += count++;
        }

        int cur = 1;
        for (int i = 1; i <= d; i++) {
            if (vertical[i] == 0) {
                vertical[i] = cur;
            }
            else {
                cur = vertical[i];
            }
        }

        /**
         * horizontal 순회하면서 각 칸에서 몇 개씩 찍는지 체크
         */
        for (int i = 0; i <= d; i++) {
            if (i % k == 0) {
                answer += vertical[getY(d, i)];
            }
        }

        return answer;
    }

    private long square(int val) {
        return Long.parseLong(String.valueOf(val)) * Long.parseLong(String.valueOf(val));
    }

    private int getY(int d, int x) {
        int left = 0;
        int right = d;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (square(d) - square(x) >= square(mid)) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return right;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int k = 2;
        int d = 4;

        long answer = s.solution(k, d);
        System.out.println("answer = " + answer);
    }
}
