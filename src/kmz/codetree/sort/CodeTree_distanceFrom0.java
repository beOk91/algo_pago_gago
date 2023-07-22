package kmz.codetree.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeTree_distanceFrom0 {
    /*
    * 2차 평면 위에 N개의 점이 주어졌을 때, 원점에서 가까운 점부터 순서대로 번호를 출력하는 프로그램을 작성해보세요. 거리가 같은 점이 여러 개인 경우, 번호가 작은 점 부터 출력합니다.
    * 단, 여기서의 거리란 멘하턴 거리를 의미합니다. 두 점 (x1, y1), (x2, y2) 사이의 멘하턴 거리는 |x1 - x2| + |y1 - y2|로 정의됩니다.
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Coordinate[] coordinates = new Coordinate[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Coordinate coordinate = new Coordinate(i + 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            coordinates[i] = coordinate;
        }
        Arrays.sort(coordinates);

        for (int i = 0; i < n; i++) {
            sb.append(coordinates[i].num)
                    .append('\n');
        }
        System.out.println(sb);
    }
}

class Coordinate implements Comparable<Coordinate> {
    int num;
    int x;
    int y;

    @Override
    public int compareTo(Coordinate coordinate) {
        int distance1 = Math.abs(this.x) + Math.abs(this.y);
        int distance2 = Math.abs(coordinate.x) + Math.abs(coordinate.y);

        if (distance1 == distance2) {
            return this.num - coordinate.num;
        } else {
            return distance1 - distance2;
        }
    }

    public Coordinate(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}