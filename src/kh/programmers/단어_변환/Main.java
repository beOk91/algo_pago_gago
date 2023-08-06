package kh.programmers.단어_변환;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static class Word {
        String value;
        int lev;

        Word(String value, int lev) {
            this.value = value;
            this.lev = lev;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = -1;
        boolean[] visit = new boolean[words.length];
        Queue<Word> q = new LinkedList<>();
        boolean success = false;

        q.add(new Word(begin, 0));

        while(!q.isEmpty()) {
            Word next = q.remove();
            if (next.value.equals(target)) {
                success = true;
                answer = next.lev;
                break;
            }

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (canVisit(next.value, word) && !visit[i]) {
                    visit[i] = true;
                    q.add(new Word(word, next.lev + 1));
                }
            }
        }

        if (!success) {
            answer = 0;
        }

        return answer;
    }

    boolean canVisit(String source, String target) {
        int cnt = 0;

        char[] sourceArr = source.toCharArray();
        char[] targetArr = target.toCharArray();
        for (int i = 0; i < sourceArr.length; i++) {
            if (sourceArr[i] == targetArr[i]) {
                cnt++;
            }
        }

        return cnt == source.length() - 1;
    }
}

public class Main {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        Solution s = new Solution();

        int answer = s.solution(begin, target, words);

        System.out.println("answer = " + answer);
    }
}
