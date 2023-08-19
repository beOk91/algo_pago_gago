package kh.programmers.양궁대회;

import java.util.*;

class Solution {

    private int maxDiff = Integer.MIN_VALUE;

    private final String APEACH = "APEACH";
    private final String RYAN = "RYAN";

    private List<Result> resultList = new ArrayList<>();
    private Set<String> resultSet = new HashSet<>();

    private class Result implements Comparable<Result> {
        String winner;
        Integer diff;
        int[] ryanScore;
        String key;

        Result(String winner, int diff) {
            this.winner = winner;
            this.diff = diff;
        }

        @Override
        public int compareTo(Result o) {

            if (this.diff.equals(o.diff) && this.diff.equals(maxDiff)) {
                if (this.winner.equals(RYAN) && o.winner.equals(RYAN)) {
                    for (int i = 10; i >= 0; i--) {
                        if (this.ryanScore[i] > o.ryanScore[i]) {
                            return -1;
                        }
                        else if (this.ryanScore[i] < o.ryanScore[i]) {
                            return 1;
                        }
                    }
                }
            }

            return o.diff.compareTo(this.diff);
        }
    }

    public int[] solution(int n, int[] info) {
        int[] answer = {};

        int[] ryan = new int[11];

        for (int i = 0; i < 11; i++) {
            dfs(n, 0, info, ryan, i);
        }

        if (resultList.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        Collections.sort(resultList);
        return resultList.get(0).ryanScore;
    }

    private void dfs(int n, int cnt, int[] apeach, int[] ryan, int curPos) {
        if (n == cnt) {
            Result result = match(apeach, ryan);
            if (result.winner.equals(RYAN) && !resultSet.contains(result.key)) {
                resultList.add(result);
                maxDiff = Math.max(maxDiff, result.diff);
                resultSet.add(result.key);
            }
            return;
        }

        for (int i = curPos; i < 11; i++) {
            ryan[curPos]++;
            dfs(n, cnt + 1, apeach, ryan, i);
            ryan[curPos]--;
        }
    }

    public Result match(int[] apeach, int[] ryan) {
        StringBuilder keyBuilder = new StringBuilder();
        int apeachScore = 0;
        int ryanScore = 0;

        for (int i = 0; i < 11; i++) {
            keyBuilder.append(ryan[i]);
            if (apeach[i] != 0 || ryan[i] != 0) {
                if (apeach[i] >= ryan[i]) {
                    apeachScore += (10 - i);
                }
                else {
                    ryanScore += (10 - i);
                }
            }
        }

        if (apeachScore >= ryanScore) {
            return new Result(APEACH, apeachScore - ryanScore);
        }
        else {
            Result result = new Result(RYAN, ryanScore - apeachScore);
            result.ryanScore = ryan.clone();
            result.key = keyBuilder.toString();
            return result;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
//        int n = 5;
//        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        int n = 10;
        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        int[] answer = s.solution(n, info);

        System.out.print("[");
        for (int a : answer) {
            System.out.print(a + ", ");
        }
        System.out.print("]");

    }
}
