package kh.baekjoon.set1.기초_자료구조_1;

import java.io.*;
import java.util.Stack;

public class 스택_10828 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static Stack<Integer> st = new Stack<>();
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
                    st.push(Integer.parseInt(split[1]));
                    break;
                case "pop":
                    bw.write(st.isEmpty() ? "-1\n" : st.pop() + "\n");
                    break;
                case "size":
                    bw.write(st.size() + "\n");
                    break;
                case "empty":
                    bw.write(st.isEmpty() ? "1\n" : "0\n");
                    break;
                case "top":
                    bw.write(st.isEmpty() ? "-1\n" : st.peek() + "\n");
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
