package kjy.week_08;

import java.util.ArrayDeque;
import java.util.Deque;

public class 단어변환_43163 {
    public int solution(String begin, String target, String[] words) {
        int[] visited = new int[words.length];

        // 첫번째 단어는 depth 가 0 이다
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(new Node(begin, 0));

        while (!queue.isEmpty()) {
            // 타겟과 현재 단어가 같으면 depth 반환
            Node curr = queue.removeFirst();
            if (target.equals(curr.getWord())) {
                return curr.getDepth();
            }

            // words를 순회하며 이미 체크한 단어인지, 다음 단어로 사용될 수 있는지 확인
            for (int i = 0; i < words.length; i++) {
                if (visited[i] == 0 && curr.isNext(words[i])) {
                    visited[i] = 1;
                    queue.addLast(new Node(words[i], curr.getDepth() + 1));
                }
            }
        }

        // 반환된 값 없이 탐색이 종료되면 해당하는 경로가 없다고 판단
        return 0;
    }
}

class Node {

    private final String word;
    private final int depth;

    Node(String word, int depth) {
        this.word = word;
        this.depth = depth;
    }

    public String getWord() {
        return this.word;
    }

    public int getDepth() {
        return this.depth;
    }

    /**
     * 한 글자만 다르면 다음 단어로 판단
     * @param word 확인할 문자
     * @return 한 글자만 다르면 true, 아니면 false
     */
    public boolean isNext(String word) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (this.word.charAt(i) != word.charAt(i)) {
                count++;

                if (count > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}