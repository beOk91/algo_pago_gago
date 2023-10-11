package kh.baekjoon.set2.백트래킹_1;

import java.io.*;
import java.util.*;

public class 로또_6603 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void solution() throws IOException {
        while(true) {
            String line = br.readLine();
            String[] nums = line.split(" ");
            if (nums[0].equals("0")) {
                break;
            }
            int k = Integer.parseInt(nums[0]);
            int[] S = new int[k];
            boolean[] visit = new boolean[k];
            Set<String> answerSet = new HashSet<>();
            List<String> answerLs = new ArrayList<>(answerSet);
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(nums[i + 1]);
            }

            dfs(0, S, visit, "", answerSet, answerLs);
            for (String answer : answerLs) {
                bw.write(answer + "\n");
            }
            bw.write("\n");
        }
    }

    private static void dfs(int lev, int[] S, boolean[] visit, String candidate, Set<String> candidateSet, List<String> answerLs) {
        if (candidateSet.contains(getAnswer(candidate))) {
            return;
        }
        if (6 == lev) {
            String answer = getAnswer(candidate);
            candidateSet.add(answer);
            answerLs.add(answer);
            return;
        }

        candidateSet.add(getAnswer(candidate));
        for (int i = 0; i < S.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(lev + 1, S, visit, lev == 0 ? candidate + S[i] : candidate + " " + S[i], candidateSet, answerLs);
                visit[i] = false;
            }
        }
    }

    private static String getAnswer(String candidate) {
        String[] nums = candidate.split(" ");
        Arrays.sort(nums, (o1, o2) -> {
            Integer o1Val = Integer.parseInt(o1);
            Integer o2Val = Integer.parseInt(o2);
            return o1Val.compareTo(o2Val);
        });
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i < nums.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}