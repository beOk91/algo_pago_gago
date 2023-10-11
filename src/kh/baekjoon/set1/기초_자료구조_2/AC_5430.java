package kh.baekjoon.set1.기초_자료구조_2;

import java.io.*;
import java.util.*;

public class AC_5430 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int T;

    private static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
    }

    private static void solution() throws IOException {
        for (int w = 0; w < T; w++) {
            char[] funcs = br.readLine().toCharArray();
            br.readLine();
            String[] nums = br.readLine().replace("[", "").replace("]", "").split(",");
            List<String> ls = new ArrayList<>(Arrays.asList(nums));

            if (!ls.isEmpty() && ls.get(0).equals("")) {
                ls.clear();
            }

            boolean success = true;
            boolean front = true;

            for (char func : funcs) {
                switch(func) {
                    case 'R':
                        front = !front;
                        break;
                    case 'D':
                        if (ls.isEmpty()) {
                            success = false;
                            break;
                        }
                        ls.remove(front ? 0 : ls.size() - 1);
                        break;
                }
                if (!success) {
                    break;
                }
            }

            if (success) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (front) {
                    for (int i = 0; i < ls.size(); i++) {
                        sb.append(ls.get(i));
                        if (i < ls.size() - 1) {
                            sb.append(",");
                        }
                    }
                }
                else {
                    for (int i = ls.size() - 1; i >= 0; i--) {
                        sb.append(ls.get(i));
                        if (i > 0) {
                            sb.append(",");
                        }
                    }
                }

                sb.append("]\n");
                bw.write(sb.toString());
            }
            else {
                bw.write("error\n");
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
