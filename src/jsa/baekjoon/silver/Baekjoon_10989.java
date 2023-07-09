import java.io.IOException;
import java.util.*;

/**
 * Collections.sort는 메모리 초과로 사용 X
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list); // 오름차순 정렬 

        for(Integer c : list) {
            sb.append(c).append("\n");
        }

        System.out.println(sb);

    }
}


//배열로 풀 경우
