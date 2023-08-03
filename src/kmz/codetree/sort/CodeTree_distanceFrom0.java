package kmz.codetree.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeTree_distanceFrom0 {
    /*
    * https://www.codetree.ai/missions/5/problems/distance-from-origin?utm_source=clipboard&utm_medium=text
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