package kh.programmers.수식_최대화;

import java.util.*;

class Solution {
    private String[] operator = {"+", "-", "*"};
    private boolean[] visit;

    private Set<String> operatorSet;

    private long max;

    public long solution(String expression) {
        long answer = 0;
        max = Long.MIN_VALUE;

        operatorSet = new HashSet<>();
        List<Long> operandLs = new ArrayList<>();
        List<String> operatorLs = new ArrayList<>();
        visit = new boolean[3];

        parse(operandLs, operatorLs, expression);

        if (operatorSet.size() == 1) {
            if ("+".equals(operatorLs.get(0))) {
                for (long l : operandLs) {
                    answer += l;
                }
            }
            else if ("-".equals(operatorLs.get(0))) {
                for (long l : operandLs) {
                    answer += l;
                }
                answer -= operandLs.get(0);
            }
            else {
                answer = operandLs.get(0);
                for (int i = 1; i < operandLs.size(); i++) {
                    answer *= operandLs.get(i);
                }
            }
            return answer;
        }

        for (int i = 0; i < 3; i++) {
            calc(i, operandLs, operatorLs, 0);
            visit[i] = false;
        }
        return max;
    }

    private void calc(int curOperandIdx, List<Long> operandLs, List<String> operatorLs, int cnt) {
        List<String> nextOperator = new ArrayList<>();
        Stack<Long> tmp = new Stack<>();

        String curOperator = operator[curOperandIdx];
        visit[curOperandIdx] = true;

        long left, right;
        String operator;

        int operandIdx = 0;
        int operatorIdx = 0;

        while(operatorIdx < operatorLs.size()) {
            if (tmp.isEmpty()) {
                left = operandLs.get(operandIdx++);
                right = operandLs.get(operandIdx++);
                operator = operatorLs.get(operatorIdx++);
            }
            else {
                left = tmp.pop();
                right = operandLs.get(operandIdx++);
                operator = operatorLs.get(operatorIdx++);
            }

            if (operator.equals(curOperator)) {
                switch(operator) {
                    case "+" -> tmp.push(left + right);
                    case "*" -> tmp.push(left * right);
                    case "-" -> tmp.push(left - right);
                }
            }
            else {
                tmp.push(left);
                tmp.push(right);
                nextOperator.add(operator);
            }
        }

        List<Long> nextOperand = new ArrayList<>(tmp);

        for (int i = 0; i < 3; i++) {
            if (visit[i]) {
                continue;
            }
            calc(i, nextOperand, nextOperator, cnt + 1);
            visit[i] = false;
        }

        if (cnt == 2) {
            max = operandLs.size() == 1 ? Math.max(max, Math.abs(operandLs.get(0))) : Math.max(max, Math.abs(nextOperand.get(0)));
        }
    }

    private void parse(List<Long> operandQueue, List<String> operatorQueue, String expression) {
        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (!Character.isDigit(c)) {
                operandQueue.add(Long.valueOf(sb.toString()));
                sb = new StringBuilder();
                operatorQueue.add(String.valueOf(c));
                if (!operatorSet.contains(String.valueOf(c))) {
                    operatorSet.add(String.valueOf(c));
                }
            }
            else {
                sb.append(c);
            }
        }
        operandQueue.add(Long.valueOf(sb.toString()));
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

//        String expression = "50*6-3*2";
        String expression = "100-200*300-500+20";
        long solution = s.solution(expression);

        System.out.println("solution = " + solution);
    }
}
