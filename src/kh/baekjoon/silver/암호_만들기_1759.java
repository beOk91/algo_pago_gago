package kh.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 암호_만들기_1759 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int L, C;
    private static String[] characters;
    private static boolean[] visit;

    private static List<String> answerList = new ArrayList<>();
    private static Set<String> set = new HashSet<>();

    private static void input() throws IOException {
        String[] line = br.readLine().split(" ");
        L = Integer.parseInt(line[0]);
        C = Integer.parseInt(line[1]);
        characters = br.readLine().split(" ");
        visit = new boolean[C];
        
        Arrays.sort(characters);
    }

    private static void solution() throws IOException {
        for (int i = 0; i < C; i++) {
            dfs(i, "", 0, 0);
        }
        for (String answer : answerList) {
            bw.write(answer + "\n");
        }
    }
     
    private static void dfs(int idx, String answer, int gather, int consonant) {
        if (answer.length() == L) {
            if (gather >= 1 && consonant >= 2 && !set.contains(answer)) {
                set.add(answer);
                answerList.add(answer);
            }
            return;
        }
        if (idx == C || visit[idx]) {
            return;
        }

        boolean isGather = isGather(characters[idx]);

        for (int i = idx; i < C; i++) {
            visit[idx] = true;
            dfs(i, answer + characters[idx], isGather ? gather + 1 : gather, isGather ? consonant : consonant + 1);
            visit[idx] = false;
        }
    }
    
    private static boolean isGather(String character) {
        return Arrays.asList("a", "e", "i", "o", "u").contains(character);
    }
    
    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}