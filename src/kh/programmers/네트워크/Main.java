package kh.programmers.네트워크;

import java.util.Set;

class Solution {

    int setId = 0;

    public int solution(int n, int[][] computers) {
        int[] table = new int[n];

        for (int i = 0; i < n; i++) {
            if (table[i] == 0) {
                setId++;
                dfs(i, table, computers);
            }
        }

        return setId;
    }

    private void dfs(int node, int[] table, int[][] computers) {
        if (node == table.length) {
            return;
        }

        table[node] = setId;

        for (int i = 0; i < table.length; i++) {
            if (i == node || computers[node][i] == 0 || table[i] != 0) {
                continue;
            }
            dfs(i, table, computers);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        Solution s = new Solution();
        int answer = s.solution(n, computers);

        System.out.println("answer = " + answer);
    }
}
