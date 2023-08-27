package kh.programmers.조이스틱;

class Solution {
    private boolean[] complete;
    private int completeCnt = 0;

    public int solution(String name) {
        int answer = 0;
        char[] spellingArr = name.toCharArray();
        int curPos = 0;

        complete = new boolean[spellingArr.length];

        for (int i = 0; i < spellingArr.length; i++) {
            char spelling = spellingArr[i];
            if (spelling == 'A') {
                complete[i] = true;
                completeCnt++;
            }
        }

        while(completeCnt < name.length()) {
            int[] nextPosInfo = getNextPos(curPos, spellingArr);
            curPos = nextPosInfo[0];
            int moveCount = nextPosInfo[1];

            answer += moveCount;
            answer += changeAlphabet('A', spellingArr[curPos]);

            complete[curPos] = true;
            completeCnt++;
        }

        return answer;
    }

    private int changeAlphabet(char current, char target) {
        if (target - current > 12) {
            return 'Z' - target + 1;
        }
        else {
            return target - current;
        }
    }

    private int[] getNextPos(int curIdx, char[] name) {
        int[] answer = new int[2];

        boolean leftFound = false;
        boolean rightFound = false;

        int leftIdx = 0;
        int rightIdx = 0;

        while(!leftFound) {
            int cal = (curIdx - leftIdx) < 0 ? name.length + (curIdx - leftIdx) : (curIdx - leftIdx);
            if (complete[cal]) {
                leftIdx++;
            }
            else {
                leftFound = true;
            }
        }
        // right
        while(!rightFound) {
            int cal = (curIdx + rightIdx) >= name.length ? (curIdx + rightIdx) - name.length : (curIdx + rightIdx);
            if (complete[cal]) {
                rightIdx++;
            }
            else {
                rightFound = true;
            }
        }

        if (leftIdx <= rightIdx) {
            answer[0] = (curIdx - leftIdx) < 0 ? name.length + (curIdx - leftIdx) : (curIdx - leftIdx);
            answer[1] = leftIdx;
        }
        else {
            answer[0] = (curIdx + rightIdx) >= name.length ? (curIdx + rightIdx) - name.length : (curIdx + rightIdx);
            answer[1] = rightIdx;
        }

        return answer;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        String name = "JEROEN";
        int answer = s.solution(name);
        System.out.println("answer = " + answer);
    }
}
