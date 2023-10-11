package kh.baekjoon.set1.기초_자료구조_2;

import java.io.*;
import java.util.Stack;

public class 괄호_9012 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static String[] parens;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        parens = new String[N];

        for (int i = 0; i < N; i++) {
            parens[i] = br.readLine();
        }
    }

    private static void solution() throws IOException {
        for (String paren : parens) {
            Stack<Character> st = new Stack<>();
            char[] charArray = paren.toCharArray();

            for (char c : charArray) {
                if (c == '(') {
                    st.push('(');
                }
                else if (c == ')') {
                    if (st.isEmpty() || st.peek() == ')') {
                        st.push(')');
                        break;
                    }
                    st.pop();
                }
            }

            bw.write(st.isEmpty() ? "YES\n" : "NO\n");
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
