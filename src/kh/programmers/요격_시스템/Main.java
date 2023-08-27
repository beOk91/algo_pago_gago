package kh.programmers.요격_시스템;

import java.util.*;

class Line implements Comparable<Line>{
    Integer s;
    Integer e;

    Line(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Line o) {
        return s.compareTo(o.s);
    }
}

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        List<Line> list = new ArrayList<>();

        for (int[] target : targets) {
            list.add(new Line(target[0], target[1]));
        }

        Collections.sort(list);

        Line tmp = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            Line cur = list.get(i);

            if (cur.e < tmp.e) tmp = cur;
            if (tmp.e <= cur.s) {
                answer++;
                tmp = cur;
            }
        }

        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        int answer = s.solution(targets);

        System.out.println("answer = " + answer);
    }

}
