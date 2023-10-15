package kh.baekjoon.set2.백트래킹_1;
import java.io.*;
import java.util.*;

public class 부분수열의_합_1182 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, S;
    private static int[] nums;
    private static Set<Integer> visitSet;

    private static int answer = 0;

    private static void input() throws IOException {
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        nums = new int[N];
//        visitSet = new HashSet<>();

        String[] nSplit = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(nSplit[i]);
        }
    }

    private static void solution() throws IOException {
        dfs(0, 0);
        bw.write((S == 0 ? (answer - 1) : answer) + "\n");
    }

    private static void dfs(int i, int tot) {
        if (i == N) {
            if (tot == S) {
                answer++;
            }
            return;
        }

        dfs(i + 1, tot + nums[i]);
        dfs(i + 1, tot);
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}