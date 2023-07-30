package kmz.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CodeTree_area_been_to_and_from {
    /*
     * https://www.codetree.ai/problems/area-been-to-and-from2?utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] line = new int[200];
        int start = 100;
        int index = 100;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            if (direction.equals("R")) {
                index += x;
            } else { // L
                index -= x;
            }
            if (start < index) {
                for (int j = start; j < index; j++) {
                    line[j]++;
                }
            } else {
                for (int j = index; j < start; j++) {
                    line[j]++;
                }
            }
            start = index;
        }
        System.out.println(Arrays.stream(line).filter(x -> x >= 2).count());
    }
}
