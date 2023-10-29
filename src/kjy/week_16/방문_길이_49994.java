package kjy.week_16;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 방문_길이_49994 {
    private static Map<String, int[]> MOVE = Map.of(
        "U", new int[]{0, 1},
        "D", new int[]{0, -1},
        "L", new int[]{-1, 0},
        "R", new int[]{1, 0}
    );

    public int solution(String dirs) {
        int x = 0, y = 0;

        Set<String> visited = new HashSet<>();
        for (String dir : dirs.split("")) {
            int nx = x + MOVE.get(dir)[0];
            int ny = y + MOVE.get(dir)[1];

            if (-5 <= nx && nx <= 5 && -5 <= ny && ny <= 5) {
                if (!visited.contains(String.format("%d%d%d%d", x, y, nx, ny))) {
                    visited.add(String.format("%d%d%d%d", x, y, nx, ny));
                    visited.add(String.format("%d%d%d%d", nx, ny, x, y));
                }
                x = nx; y = ny;
            }
        }

        return visited.size() / 2;
    }
}
