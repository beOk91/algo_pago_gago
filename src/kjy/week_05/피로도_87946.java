package kjy.week_05;

public class 피로도_87946 {
    private int depth = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        explore(dungeons, visited, k, 0);
        return depth;
    }

    public void explore(int[][] dungeons, boolean[] visited, int fatigue, int count) {
        if (count > depth) {
            depth = count;
        }

        // 모든 던전을 탐험했다면 패스
        if (count == dungeons.length) {
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            // 이미 방문했거나 던전의 피로도 요구치가 현재 피로도보다 더 높다면 패스
            if (visited[i] == true || dungeons[i][0] > fatigue) {
                continue;
            }

            visited[i] = true;
            explore(dungeons, visited, fatigue - dungeons[i][1], count + 1);
            visited[i] = false;
        }
    }
}
