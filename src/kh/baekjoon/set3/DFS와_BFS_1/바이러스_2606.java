package kh.baekjoon.set3.DFS와_BFS_1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 바이러스_2606 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, M;
    private static Map<Integer, List<Integer>> graph;
    private static boolean[] infected;

    private static int infectedCnt = -1;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        String[] line;

        graph = new HashMap<>();
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

        infected = new boolean[N + 1];
    }

    private static void solution() throws IOException {
        dfs(1);
        bw.write(infectedCnt + "\n");
    }

    private static void dfs(int node) {
        if (infected[node]) {
            return;
        }

        infected[node] = true;
        List<Integer> adjList = graph.get(node);
        infectedCnt++;

        for (int adjNode : adjList) {
            dfs(adjNode);
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