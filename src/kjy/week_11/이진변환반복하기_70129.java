package kjy.week_11;

public class 이진변환반복하기_70129 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        // s가 "1"이 될 때까지
        while (!"1".equals(s)) {
            answer[0]++;    // 이진 변환 횟수
            answer[1] += s.length();
            s = s.replaceAll("0", "");  // "0" 제거
            int remain = s.length();    // "1"의 개수
            s = Integer.toBinaryString(remain);
            answer[1] -= remain;    // 전체 - "1"의 개수 = 제거한 0의 개수
        }

        return answer;
    }
}