package kmz.codetree.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeTree_kthNumber {
    /*
     * 단어가 n개 주어졌을 때, 문자열 T로 시작하는 단어들 중 사전순으로 정렬했을 때의 k번째 문자열을 출력하는 프로그램을 작성해보세요.
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
