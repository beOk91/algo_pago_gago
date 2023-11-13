package kh.baekjoon.set4.그리디_알고리즘_1;

import java.io.*;

public class 동전_0_11047 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, K;
    private static int[] A;
    
    private static void input() throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);
        A = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void solution() throws IOException {
        int answer = 0;
        int start = getStart();
        int remain = K;

        for (int i = start; i >= 0; i--) {
            if (remain % A[i] == 0) {
                answer += remain / A[i];
                break;
            }

            answer += remain / A[i];
            remain %= A[i];
        }

        bw.write(answer + "\n");
    }

    private static int getStart() {
        int answer = N - 1;
        
        for (int i = N - 1; i >= 0; i--) {
            if (K >= A[i]) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        input();

        solution();

        br.close();
        bw.flush();
        bw.close();
    }
}
