package kjy.week_10;

import java.util.HashSet;
import java.util.Set;

public class 순위_49191 {
    public int solution(int n, int[][] results) {
        // 선수 i가 이긴 선수
        Player[] wins = new Player[n + 1];
        // 선수 i를 이긴 선수
        Player[] loses = new Player[n + 1];

        for (int i = 1; i < n + 1; i++) {
            wins[i] = new Player();
            loses[i] = new Player();
        }

        for (int[] result: results) {
            int winner = result[0];
            int loser = result[1];
            wins[winner].set.add(loser);
            loses[loser].set.add(winner);
        }

        for (int i = 1; i < n + 1; i++) {
            // 나를 이긴 선수들은 내가 이긴 선수들을 다 이긴다
            for (int winner: loses[i].set) {
                wins[winner].set.addAll(wins[i].set);
            }

            // 내게 진 선수들은 나를 이긴 선수들에게 다 진다
            for (int loser: wins[i].set) {
                loses[loser].set.addAll(loses[i].set);
            }
        }
        
        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            // 내가 이긴 사람과 내게 진 사람이 모두 정해지면 서열 정리 완료
            if (wins[i].set.size() + loses[i].set.size() == n - 1) {
                answer++;
            }
        }
        return answer;
    }
}
class Player {
    public Set<Integer> set;

    public Player() {
        this.set = new HashSet<>();
    }
}