package kjy.week_06;

public class 조이스틱_42860 {
    public int solution(String name) {
        int length = name.length();
        
        int select = 0;
        int move = length - 1;
        
        for (int i = 0; i < length; i++) {
            // 다음 알파벳 vs 이전 알파벳 (A는 그대로)
            select += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            // 연속 A 갯수 확인 (select 변동 없음) => 쭉 이동
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            
            // 지금까지 온 순서대로 쭉 진행 vs 뒤로 돌아가기
            move = Math.min(move, i * 2 + length - next);
            
            // 지금까지 온 순서대로 쭉 진행 vs 뒤 먼저 하고 지금꺼 처리하기
            move = Math.min(move, (length - next) * 2 + i);
        }
        
        return select + move;
    }
}
