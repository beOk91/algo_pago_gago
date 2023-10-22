package kh.baekjoon.set2.백트래킹_2;

import java.io.*;

public class 좋은수열_2661 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;

    private static String answer;

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }

    private static void solution() throws IOException {
        dfs("", 1);
        bw.write(answer + "\n");
    }

    private static void dfs(String num, int nextNum) {
        if (num.length() == N) {
            answer = num;
            return;
        }
        if (answer != null) {
            return;
        }

        if (canPut(num, nextNum)) {
            dfs(num + nextNum, 1);
            dfs(num + nextNum, 2);
            dfs(num + nextNum, 3);
        }
    }

    private static boolean canPut(String curNum, int nextNum) {
        if (curNum.isEmpty()) {
            return true;
        }

        if (Integer.parseInt(curNum.substring(curNum.length() - 1)) == nextNum) {
            return false;
        }

        String newNum = curNum + nextNum;
        int length = 2;
        while(length <= newNum.length() / 2) {
            String right = newNum.substring(newNum.length() - length);
            String left = newNum.substring(newNum.length() - (2 * length), newNum.length() - length);

            if (left.equals(right)) {
                return false;
            }
            length++;
        }

        return true;
    }



    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}
