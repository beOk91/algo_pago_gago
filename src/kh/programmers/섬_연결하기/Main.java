package kh.programmers.섬_연결하기;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    private static class Node {

        private int depth = 1;
        private Node parent;

        public boolean isConnected(Node o) {
            return root() == o.root();
        }

        public void merge(Node o) {
            if (isConnected(o)) {
                return;
            }

            Node root1 = root();
            Node root2 = o.root();

            if (root1.depth > root2.depth) {
                root2.parent = root1;
            }
            else if (root1.depth < root2.depth) {
                root1.parent = root2;
            }
            else {
                root2.parent = root1;
                root1.depth++;
            }

        }

        public Node root() {
            if (this.parent == null) {
                return this;
            }
            else {
                return parent.root();
            }
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;

        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }

        Arrays.sort(costs, new Comparator<>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] > o2[2]) return 1;
                else if (o1[2] < o2[2]) return -1;
                else return 0;
            }
        });

        for (int[] info : costs) {
            Node v = nodes[info[0]];
            Node w = nodes[info[1]];

            if (!v.isConnected(w)) {
                v.merge(w);
                answer += info[2];
            }
        }

        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        int answer = s.solution(n, costs);

        System.out.println("answer = " + answer);

    }
}
