package kh.programmers.광물_캐기;


class Solution {

    private int answer = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {

        for (int i= 0; i < 3; i++) {
            int[] tmpPicks = picks.clone();
            dfs(i, 0, tmpPicks, minerals, 0);
        }

        return answer;
    }

    private void dfs(int pickIdx, int mineralIdx, int[] picks, String[] minerals, int fatigue) {
        if (picks[pickIdx] == 0 && noMore(picks)) {
            answer = Math.min(answer, fatigue);
            // 더 이상 순회 불가능
            return;
        }
        if (picks[pickIdx] == 0) {
            // 더 이상 순회 불가능
            return;
        }
        if (mineralIdx == minerals.length) {
            answer = Math.min(answer, fatigue);
            return;
        }

        picks[pickIdx]--;
        int tmpFatigue = fatigue;
        for (int i = mineralIdx; i < mineralIdx + 5; i++) {
            if (i == minerals.length) {
                answer = Math.min(answer, tmpFatigue);
                picks[pickIdx]++;
                return;
            }
            tmpFatigue += getFatigue(pickIdx, minerals[i]);
        }
        dfs(0, mineralIdx + 5, picks, minerals, tmpFatigue);
        dfs(1, mineralIdx + 5, picks, minerals, tmpFatigue);
        dfs(2, mineralIdx + 5, picks, minerals, tmpFatigue);
        picks[pickIdx]++;
    }

    private boolean noMore(int[] picks) {
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private int getFatigue(int pick, String mineral) {
        int answer = 1;

        if (pick == 1 && mineral.equals("diamond")) {
            answer = 5;
        }
        else if (pick == 2 && mineral.equals("diamond")) {
            answer = 25;
        }
        else if (pick == 2 && mineral.equals("iron")) {
            answer = 5;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] picks = {1, 1, 0};
        String[] minerals = {"iron", "iron", "diamond", "iron", "stone", "diamond", "diamond", "diamond"};
        int answer = s.solution(picks, minerals);

        System.out.println("answer = " + answer);
    }
}
