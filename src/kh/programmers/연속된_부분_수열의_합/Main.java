package kh.programmers.연속된_부분_수열의_합;

import java.util.*;


class Pair implements Comparable<Pair> {
    Integer s;
    Integer e;
    Integer dist;

    Pair(int s, int e) {
        this.s = s;
        this.e = e;
        this.dist = e - s;
    }

    @Override
    public int compareTo(Pair o) {
        return dist.compareTo(o.dist);
    }
}

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        List<Pair> ls = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;
        int sum = sequence[p1];

        // p2 --- p1
        while (p1 < sequence.length && p2 < sequence.length) {
            if (sum == k) {
                ls.add(new Pair(p2, p1++));
                if (p1 == sequence.length) break;
                sum += sequence[p1];
            }
            else if (sum < k) {
                p1++;
                if (p1 == sequence.length) break;
                sum += sequence[p1];
            }
            else if (sum > k) {
                sum -= sequence[p2++];
                if (p2 == sequence.length) break;
            }
        }

        Collections.sort(ls);

        answer[0] = ls.get(0).s;
        answer[1] = ls.get(0).e;

        return answer;
    }
}
public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;

        int[] answer = s.solution(sequence, k);

        System.out.println("answer = " + answer);
    }
}
