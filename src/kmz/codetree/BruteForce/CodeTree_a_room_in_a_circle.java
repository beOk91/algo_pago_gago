package kmz.codetree.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeTree_a_room_in_a_circle {
    /*
     * https://www.codetree.ai/missions/5/problems/a-room-in-a-circle?&utm_source=clipboard&utm_medium=text
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] roomPeople = new int[n];

        for (int i = 0; i < n; i++) {
            roomPeople[i] = Integer.parseInt(br.readLine());
        }
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int totalDistance = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int distance = (j - i + n) % n;
                    totalDistance += roomPeople[j] * distance;
                }
            }
            if (totalDistance < minDistance) {
                minDistance = totalDistance;
            }
        }
        System.out.println(minDistance);
    }
}
