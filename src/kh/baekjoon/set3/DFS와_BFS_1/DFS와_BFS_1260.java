package kh.baekjoon.set3.DFS와_BFS_1;

import java.io.*;
import java.util.*;

public class DFS와_BFS_1260 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, M, V;
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static boolean[] visit;
    private static boolean success = false;

    private static void input() throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        V = Integer.parseInt(line[2]);

        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int v = Integer.parseInt(line[0]);
            int w = Integer.parseInt(line[1]);

            graph.get(v).add(w);
            graph.get(w).add(v);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }
    }

    private static void solution() throws IOException {
        List<Integer> dfsAnswer = new ArrayList<>();
        List<Integer> bfsAnswer = new ArrayList<>();

        dfs( V, dfsAnswer);

        visit = new boolean[N + 1];
        success = false;

        bfs(V, bfsAnswer);

        for (int i = 0; i < dfsAnswer.size(); i++) {
            bw.write(dfsAnswer.get(i) + (i == dfsAnswer.size() - 1 ? "" : " "));
        }
        bw.write("\n");

        for (int i = 0; i < bfsAnswer.size(); i++) {
            bw.write(bfsAnswer.get(i) + (i == bfsAnswer.size() - 1 ? "" : " "));
        }
        bw.write("\n");

    }

    private static void bfs(int start, List<Integer> answer) throws IOException {
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        while(!q.isEmpty()) {
            int node = q.remove();
            if (visit[node]) {
                continue;
            }
            visit[node] = true;
            answer.add(node);

            List<Integer> adjList = graph.get(node);

            for (int nextNode : adjList) {
                if (!visit[nextNode]) {
                    q.add(nextNode);
                }
            }
        }

    }

    private static void dfs(int node, List<Integer> answer) throws IOException {
        if (answer.size() == N) {
            success = true;
            return;
        }

        visit[node] = true;
        answer.add(node);

        List<Integer> adjList = graph.get(node);
        for (int nextNode : adjList) {
            if (!visit[nextNode]) {
                dfs(nextNode, answer);
            }
            if (success) {
                return;
            }
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
