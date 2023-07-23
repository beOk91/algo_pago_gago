package kh.programmers.길_찾기_게임;

import java.util.*;

class Solution {

    private static class Node implements Comparable<Node> {
        Node left;
        Node right;
        int num;
        Integer x;
        Integer y;

        Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.y.equals(o.y)) {
                return this.x.compareTo(o.x);
            }
            return o.y.compareTo(this.y);
        }
    }

    private void add(Node target, Node source) {
        if (target.x > source.x) {
            if (target.left == null) {
                target.left = source;
                return;
            }
            add(target.left, source);
        }
        else {
            if (target.right == null) {
                target.right = source;
                return;
            }
            add(target.right, source);
        }
    }

    private void preorder(Node node, List<Integer> preList) {
        if (node == null) {
            return;
        }

        preList.add(node.num);
        preorder(node.left, preList);
        preorder(node.right, preList);
    }

    private void postorder(Node node, List<Integer> postList) {
        if (node == null) {
            return;
        }

        postorder(node.left, postList);
        postorder(node.right, postList);
        postList.add(node.num);
    }


    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        List<Integer> preList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();

        int num = 1;
        for (int[] pos : nodeinfo) {
            pq.add(new Node(num++, pos[0], pos[1]));
        }

        // Tree 구성
        Node root = pq.remove();
        while(!pq.isEmpty()) {
            add(root, pq.remove());
        }

        preorder(root, preList);
        postorder(root, postList);

        answer[0] = preList.stream().mapToInt(i->i).toArray();
        answer[1] = postList.stream().mapToInt(i->i).toArray();

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};

        int[][] solution = s.solution(nodeinfo);
        for (int[] sol : solution) {
            for (int n : sol) {
                System.out.print(n + ", ");
            }
            System.out.println();
        }
    }
}
