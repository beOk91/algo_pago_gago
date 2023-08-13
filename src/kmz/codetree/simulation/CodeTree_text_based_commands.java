package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_text_based_commands {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        StringTokenizer st = new StringTokenizer(br.readLine());
        String directions = st.nextToken();
        int x = 0; int y = 0;
        int dirNum = 3;
        for (int i = 0; i < directions.length(); i++) {
            char dir = directions.charAt(i);
            if (dir == 'L') {
                dirNum--;
            } else if (dir == 'R') {
                dirNum++;
            } else {
                if (dirNum < 0) {
                    dirNum += 4;
                }
                x += dx[(dirNum + 4) % 4];
                y += dy[(dirNum + 4) % 4];
            }
        }
        System.out.println(x + " " + y);
    }
}
