package kh.programmers.모음_사전;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private String[] alphabet = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        int answer = 0;
        List<String> dict = new ArrayList<>();
        makeWord("", dict);

        answer = dict.indexOf(word);

        return answer;
    }

    private void makeWord(String word, List<String> dict) {
        dict.add(word);
        if (word.length() == 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            makeWord(word + alphabet[i], dict);
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
