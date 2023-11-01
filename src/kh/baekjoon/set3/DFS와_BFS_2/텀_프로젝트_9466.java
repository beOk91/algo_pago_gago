package kh.baekjoon.set3.DFS와_BFS_2;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 텀_프로젝트_9466 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int T, n;
    private static int[] target;
    private static boolean[] visit;
    private static Set<Integer> remain;
    private static int loopStart;
    private static boolean loopEnd;

    private static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
    }

    private static void solution() throws IOException {
        for (int w = 0; w < T; w++) {
            n = Integer.parseInt(br.readLine());
            target = new int[n];
            visit = new boolean[n];
            int answer = 0;

            String[] line = br.readLine().split(" ");
            
            for (int i = 0; i < n; i++) {
                target[i] = Integer.parseInt(line[i]) - 1;
            }
            
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    remain = new HashSet<>();
                    loopStart = -1;
                    loopEnd = false;
                    dfs(i);
                    answer += remain.size();
                }
            }

            bw.write(answer + "\n");
        }
    }
    
    private static void dfs(int student) {
        if (remain.contains(student)) {
            loopStart = student;
            return;
        }
        if (visit[student]) {
            return;
        }

        visit[student] = true;
        remain.add(student);
        
        dfs(target[student]);
        if (student == loopStart) {
            remain.remove(student);
            loopEnd = true;
            return;
        }
        if (!loopEnd && loopStart > -1) {
            remain.remove(student);
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}