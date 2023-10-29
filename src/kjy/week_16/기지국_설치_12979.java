package kjy.week_16;

public class 기지국_설치_12979 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;
        int stationIndex = 0;

        while (position <= n) {
            if (stationIndex < stations.length && stations[stationIndex] - w <= position) {
                // 커버리지 안에 존재
                position = stations[stationIndex++] + w + 1;
            } else {
                // 커버리지 밖에 존재
                // 기지국 커버리지는 w + 1 + w 범위이므로, 그만큼 포지션 이동한 다음 탐색
                position += w * 2 + 1;
                answer++;
            }
        }

        return answer;
    }
}
