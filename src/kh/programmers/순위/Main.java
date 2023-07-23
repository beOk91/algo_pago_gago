package kh.programmers.순위;

class Solution {

    private boolean[] visit;


    public int solution(int n, int[][] results) {
        int answer = 0;

        boolean[][] forwardGraph = new boolean[n + 1][n + 1];
        int[] forwardReachable = new int[n + 1];
        boolean[][] backwardGraph = new boolean[n + 1][n + 1];
        int[] backwardReachable = new int[n + 1];


        for (int[] result : results) {
            forwardGraph[result[0]][result[1]] = true;
            backwardGraph[result[1]][result[0]] = true;
        }

        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            dfs(i, forwardGraph, forwardReachable);
            visit = new boolean[n + 1];
            dfs(i, backwardGraph, backwardReachable);
        }

        for (int i = 1; i <= n; i++) {
            if (backwardReachable[i] + forwardReachable[i] - 1 == n) {
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int n, boolean[][] graph, int[] reachable) {
        if (visit[n]) {
            return;
        }
        visit[n] = true;
        reachable[n]++;

        boolean[] vertices = graph[n];

        for (int i = 1; i < vertices.length; i++) {
            boolean isAdj = vertices[i];
            if (isAdj) {
                dfs(i, graph, reachable);
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        int answer = solution.solution(n, results);

        System.out.println("answer = " + answer);
    }

}
