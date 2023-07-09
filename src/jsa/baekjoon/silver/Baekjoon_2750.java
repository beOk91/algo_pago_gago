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

//클래스 사용 대신 배열로 풀 경우 
// for(int i=0;i<n;i++){
//       arr[i] = br.readLine();
//     }

//     for(int i=0;i<n;i++){
//       for(int j=i+1;j<n;j++){
//         if(arr[i]>arr[j]){
//           temp=arr[i];
//           arr[i] = arr[j];
//           arr[j] = temp;
//         }
//       }
//     }