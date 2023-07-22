package kmz.codetree.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CodeTree_indexOfSortedNum {
    /*
    * 양의 정수를 원소로 갖는 길이가 N인 수열이 입력으로 주어졌을 때, 이 수열을 오름차순으로 정렬 했을 때 각각의 위치에 있던 원소가 어느 위치로 이동하는지 출력하는 코드를 작성해보세요.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine().trim());

        Number[] numbers = new Number[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            Number number = new Number(Integer.parseInt(st.nextToken()), i + 1);
            numbers[i] = number;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < n; i++) {
            numbers[i].setSort_order(i + 1);
        }
        Arrays.sort(numbers, new Comparator<Number>() {
            @Override
            public int compare(Number n1, Number n2) {
                return n1.first_order - n2.first_order;
            }
        });
        for (int i = 0; i < n; i++) {
            sb.append(numbers[i].sort_order)
                    .append(" ");
        }
        System.out.println(sb);
    }
}

class Number implements Comparable<Number> {
    int num;
    int first_order;
    int sort_order;

    public Number(int num, int first_order) {
        this.num = num;
        this.first_order = first_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }

    @Override
    public int compareTo(Number number) {
        return this.num - number.num;
    }
}