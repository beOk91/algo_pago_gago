import java.io.IOException;
import java.util.*;

/**
 * Collections.sort 사용 (time sort)
 * 기존 Array.sort 사용시 시간 초과 (시간복잡도 ^2)
 * Scanner, StringBuilder, BufferedReader test 정리 필요
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