package kmz.codetree.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeTree_g_or_h_2 {
    /*
     * https://www.codetree.ai/missions/5/problems/G-or-H-2?&utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxNum = 101;

        if (n == 1) {
            System.out.println(0);
            return;
        }

        int[] personList = new int[maxNum];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int index = Integer.parseInt(st.nextToken());
            String alphabet = st.nextToken();
            if (alphabet.equals("G")) {
                personList[index] = 1;
            } else {
                personList[index] = 2;
            }
        }

        int maxSize = 0;
        for (int i = 0; i < maxNum; i++) {
            for (int j = i; j < maxNum; j++) {
                int gNum = 0; int hNum = 0;
                if (personList[i] != 0 && personList[j] != 0) {
                    for (int k = i; k <= j; k++) {
                        if (personList[k] == 1) {
                            gNum++;
                        } else if (personList[k] == 2) {
                            hNum++;
                        }
                    }
                    if ((gNum != 0 && gNum == hNum) || (gNum == 0 && hNum > 1) || (hNum == 0 && gNum > 1)) {
                        int temp = j - i;
                        maxSize = Math.max(maxSize, temp);
                    }
                }
            }
        }
        System.out.println(maxSize);
    }
}
