package kmz.codetree.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_find_hidden_words_2 {
    /*
     * https://www.codetree.ai/missions/5/problems/find-hidden-words-2?&utm_source=clipboard&utm_medium=text
     */
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L') {
                    for (int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (inRange(nx, ny) && grid[nx][ny] == 'E') {
                            nx += dx[k];
                            ny += dy[k];
                            if (inRange(nx, ny) && grid[nx][ny] == 'E') {
                                result++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
}
