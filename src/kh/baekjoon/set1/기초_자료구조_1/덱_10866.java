package kh.baekjoon.set1.기초_자료구조_1;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class 덱_10866 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static List<Integer> dequeue = new LinkedList<>();
    private static String[] commands;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        commands = new String[N];
        for (int i = 0; i < N; i++) {
            commands[i] = br.readLine();
        }
    }

    private static void solution() throws IOException {
        for (String command : commands) {
            String[] split = command.split(" ");

            switch (split[0]) {
                case "push_front":
                    dequeue.add(0, Integer.parseInt(split[1]));
                    break;
                case "push_back":
                    dequeue.add(Integer.parseInt(split[1]));
                    break;
                case "pop_front":
                    bw.write(dequeue.isEmpty() ? "-1\n" : dequeue.remove(0) + "\n");
                    break;
                case "pop_back":
                    bw.write(dequeue.isEmpty() ? "-1\n" : dequeue.remove(dequeue.size() - 1) + "\n");
                    break;
                case "size":
                    bw.write(dequeue.size() + "\n");
                    break;
                case "empty":
                    bw.write(dequeue.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    bw.write(dequeue.isEmpty() ? "-1\n" : dequeue.get(0) + "\n");
                    break;
                case "back":
                    bw.write(dequeue.isEmpty() ? "-1\n" : dequeue.get(dequeue.size() - 1) + "\n");
                    break;
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