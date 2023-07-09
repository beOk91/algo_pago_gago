import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 메모리 효율, 속도 빠름
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());// 배열 크기
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); // 오름차순 정렬

        for (int num : arr){
            System.out.println(num);
        }
    }
}
