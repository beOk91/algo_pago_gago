package kh.baekjoon.set1.기초_자료구조_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 스택_수열_1874 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int n;
    private static int[] nums;
    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void solution() throws IOException {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int num = 1;
        List<String> ls = new ArrayList<>();
        boolean success = true;

        while(true) {
            if (i == n) {
                break;
            }
            if (nums[i] > num) {
                st.push(num);
                ls.add("+");
                num++;
            }
            else if (nums[i] == num) {
                ls.add("+");
                ls.add("-");
                i++;
                num++;
            }
            else if (nums[i] < num) {
                if (st.isEmpty() || num < st.peek() || nums[i] < st.peek()) {
                    success = false;
                    break;
                }
                else if (st.peek().equals(nums[i])) {
                    ls.add("-");
                    i++;
                    st.pop();
                }
                else {
                    ls.add("+");
                    num++;
                }
            }
        }

        if (!success) {
            bw.write("NO\n");
        }
        else {
            for (String s : ls) {
                bw.write(s + "\n");
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
