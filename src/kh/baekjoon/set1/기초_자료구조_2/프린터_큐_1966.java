package kh.baekjoon.set1.기초_자료구조_2;

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프린터_큐_1966 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int T, N, M;
    private static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
    }

    static class Document {
        int idx;
        int priority;

        Document(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    private static void solution() throws IOException {
        for (int w = 0; w < T; w++) {
            String[] split = br.readLine().split(" ");
            N = Integer.parseInt(split[0]);
            M = Integer.parseInt(split[1]);
            int count = 0;

            Queue<Document> q = new LinkedList<>();
            String[] documents = br.readLine().split(" ");
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < documents.length; i++) {
                q.add(new Document(i, Integer.parseInt(documents[i])));
                pq.add(Integer.parseInt(documents[i]));
            }

            while(true) {
                Document document = q.remove();
                if (document.priority < pq.peek()) {
                    q.add(document);
                }
                else {
                    count++;
                    pq.remove();
                    if (document.idx == M) {
                        bw.write(count + "\n");
                        break;
                    }
                }
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