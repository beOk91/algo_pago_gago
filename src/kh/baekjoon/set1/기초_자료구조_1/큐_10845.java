package kh.baekjoon.set1.기초_자료구조_1;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class 큐_10845 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static List<Integer> q = new LinkedList<>();
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
                case "push":
                    q.add(Integer.parseInt(split[1]));
                    break;
                case "pop":
                    bw.write(q.isEmpty() ? "-1\n" : q.remove(0) + "\n");
                    break;
                case "size":
                    bw.write(q.size() + "\n");
                    break;
                case "empty":
                    bw.write(q.isEmpty() ? "1\n" : "0\n");
                    break;
                case "front":
                    bw.write(q.isEmpty() ? "-1\n" : q.get(0) + "\n");
                    break;
                case "back":
                    bw.write(q.isEmpty() ? "-1\n" : q.get(q.size() - 1) + "\n");
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
