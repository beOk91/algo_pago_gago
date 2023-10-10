package kh.baekjoon.set1.기초_자료구조_1;

import java.io.*;
import java.util.Stack;

public class 에디터_1406 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static char[] editor;
    private static String[] commands;
    private static Stack<Character> left, right;
    private static int M;

    private static void input() throws IOException {
        editor = br.readLine().toCharArray();
        left = new Stack<>();
        right = new Stack<>();
        for (char c : editor) {
            left.push(c);
        }

        M = Integer.parseInt(br.readLine());
        commands = new String[M];

        for (int i = 0; i < M; i++) {
            commands[i] = br.readLine();
        }
    }

    private static void solution() throws IOException {
        for (String command : commands) {
            String[] split = command.split(" ");

            switch(split[0]) {
                case "L":
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case "D":
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case "B":
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                case "P":
                    left.push(split[1].charAt(0));
                    break;
            }
        }
        StringBuilder lsb = new StringBuilder();
        StringBuilder rsb = new StringBuilder();

        while(!left.isEmpty()) {
            lsb.append(left.pop());
        }
        lsb.reverse();
        while(!right.isEmpty()) {
            rsb.append(right.pop());
        }

        bw.write(lsb.toString() + rsb.toString() + "\n");
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}
