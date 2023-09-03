package kh.programmers.택배상자;

import java.util.*;

class Solution {

    // 3 1 2 5
    // (mainmin)5
    // (submax)2 1 -> 뒤에 있는 애들일수록 작음

    public int solution(int[] order) {
        int answer = 0;
        // 보조 컨테이너
        Stack<Integer> st = new Stack<>();
        // 컨테이너
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= order.length; i++) q.add(i);

        while (answer < order.length) {
            int mainN = Integer.MAX_VALUE;
            int subN = Integer.MAX_VALUE;

            if (!q.isEmpty()) mainN= q.peek();
            if (!st.isEmpty()) subN = st.peek();

            if (mainN == order[answer]) {
                q.remove();
                answer++;
            }
            else if(subN == order[answer]) {
                if (subN != Integer.MAX_VALUE) st.pop();
                answer++;
            }
            else if (mainN < order[answer]) {
                if (q.isEmpty()) break;
                st.push(q.remove());
            }
            else {
                break;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] orders = {4, 3, 1, 2, 5};
        int answer = s.solution(orders);
        System.out.println("answer = " + answer);
    }
}
