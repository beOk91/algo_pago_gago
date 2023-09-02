package kmz.codetree.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_on_the_checkboard {
    /*
     * https://www.codetree.ai/missions/5/problems/on-the-checkboard-2?&utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[][] checkBoard = new String[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < c; j++) {
                checkBoard[i][j] = st.nextToken();
            }
        }

        int result = 0;
        for (int i = 1; i < r - 2; i++) {
            for (int j = 1; j < c - 2; j++) {
                for (int k = i + 1; k < r - 1; k++) {
                    for (int l = j + 1; l < c - 1; l++) {
                        if (!checkBoard[0][0].equals(checkBoard[i][j]) && !checkBoard[i][j].equals(checkBoard[k][l])
                                && !checkBoard[k][l].equals(checkBoard[r - 1][c - 1])) {
                            result++;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
