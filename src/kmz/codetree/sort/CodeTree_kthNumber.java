package kmz.codetree.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeTree_kthNumber {
    /*
     * https://www.codetree.ai/missions/5/problems/kth-special-string?utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String t = st.nextToken();

        ArrayList<String> nouns = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String noun = br.readLine();
            if (noun.startsWith(t)) {
                nouns.add(noun);
            }
        }
        String[] sortedNouns = nouns.toArray(new String[nouns.size()]);
        Arrays.sort(sortedNouns);
        System.out.println(sortedNouns[k - 1]);
    }
}
