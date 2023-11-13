package kh.baekjoon.set4.그리디_알고리즘_1;

import java.io.*;

public class 부등호_2529 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int k;
    private static String[] sign;

    private static void input() throws IOException {
        k = Integer.parseInt(br.readLine());
        sign = br.readLine().split(" ");
    }

    private static void solution() throws IOException {
        bw.write(max() + "\n");
        bw.write(min() + "\n");
    }

    private static String max() {
        StringBuilder answer = new StringBuilder();
        int lt = 0;
        int pos = 9;

        for (int i = 0; i < k; i++) {
            if (sign[i].equals("<")) {
                lt++;
            }
            else {
                int next = pos - lt - 1;
                while(lt > 0) {
                    answer.append((pos - lt--));
                }
                answer.append(pos);
                pos = next;
            }
        }
        while(lt > 0) {
            answer.append(pos - lt--);
        }
        answer.append(pos);


        return answer.toString();
    }

    private static String min() {
        StringBuilder answer = new StringBuilder();
        int pos = 0;
        int gt = 0;

        for (int i = 0; i < k; i++) {
            if (sign[i].equals(">")) {
                gt++;
            }
            else {
                int next = pos + gt + 1;
                while(gt > 0) {
                    answer.append((pos + gt--));
                }
                answer.append(pos);
                pos = next;
            }
        }
        while(gt > 0) {
            answer.append((pos + gt--));
        }
        answer.append(pos);

        return answer.toString();
    }

    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}
