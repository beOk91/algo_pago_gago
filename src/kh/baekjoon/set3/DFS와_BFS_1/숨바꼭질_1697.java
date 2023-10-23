package kh.baekjoon.set3.DFS와_BFS_1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질_1697 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, K;

    private static void input() throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);
    }

    private static void solution() throws IOException {
        int answer = bfs();

        bw.write(answer + "\n");
    }

    private static class State {
        int pos;
        int count;

        State(int pos, int count) {
            this.pos = pos;
            this.count = count;
        }
    }

    private static int bfs() {
        int answer = 0;
        Queue<State> q = new LinkedList<>();
        boolean[] visit = new boolean[100001];

        q.add(new State(N, 0));

        while(!q.isEmpty()) {
            State cur = q.remove();
            int X = cur.pos;

            if (X == K) {
                answer = cur.count;
                break;
            }

            if (X - 1 >= 0 && !visit[X - 1]) {
                q.add(new State(X - 1, cur.count + 1));
                visit[X - 1] = true;
            }
            if (X + 1 <= 100000 && !visit[X + 1]) {
                q.add(new State(X + 1, cur.count + 1));
                visit[X + 1] = true;
            }
            if (2 * X <= 100000 && !visit[2 * X]) {
                q.add(new State(2 * X, cur.count + 1));
                visit[2 * X] = true;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}