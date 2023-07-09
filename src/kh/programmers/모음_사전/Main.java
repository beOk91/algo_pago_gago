package kh.programmers.모음_사전;

import java.util.PriorityQueue;

class Solution {

    private String[] alphabet = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        int answer = 0;
        PriorityQueue<String> dict = new PriorityQueue<>();

        for (int i = 1; i <= 5; i++) {
            makeWord(i, "", dict);
        }

        int idx = 1;

        while(!dict.isEmpty()) {
            String curWord = dict.remove();
            if (curWord.equals(word)) {
                answer = idx;
                break;
            }
            idx++;
        }

        return answer;
    }

    private void makeWord(int n, String word, PriorityQueue<String> dict) {
        if (word.length() == n) {
            dict.add(word);
            return;
        }

        for (int i = 0; i < 5; i++) {
            makeWord(n, word + alphabet[i], dict);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String word = "I";

        int solution = s.solution(word);
        System.out.println("solution = " + solution);
    }
}
