package kh.programmers.이중우선순위큐;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    private static class Number implements Comparable<Number> {
        Integer value;

        boolean deleted;

        Number(int value) {
            this.value = value;
            deleted = false;
        }

        @Override
        public int compareTo(Number o) {
            return value.compareTo(o.value);
        }
    }

    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Number> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Number> minHeap = new PriorityQueue<>();

        int insertCount = 0;

        for (String operation : operations) {
            String[] split = operation.split(" ");
            int numVal = Integer.parseInt(split[1]);
            switch(split[0]) {
                case "I" -> {
                    Number number = new Number(numVal);
                    maxHeap.add(number);
                    minHeap.add(number);
                    insertCount++;
                }
                case "D" -> {
                    if (numVal == 1) {
                        if (!maxHeap.isEmpty()) {
                            maxHeap.remove().deleted = true;
                        }
                    }
                    else if (numVal == -1) {
                        if (!minHeap.isEmpty()) {
                            minHeap.remove().deleted = true;
                        }
                    }
                }
            }
        }

        if (maxHeap.size() + minHeap.size() > insertCount) {
            while(!maxHeap.isEmpty() && maxHeap.peek().deleted) {
                maxHeap.remove();
            }
            answer[0] = maxHeap.peek().value;
            while(!minHeap.isEmpty() && minHeap.peek().deleted) {
                minHeap.remove();
            }
            answer[1] = minHeap.peek().value;
        }

        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};

        int[] solution = s.solution(operations);


    }

}
