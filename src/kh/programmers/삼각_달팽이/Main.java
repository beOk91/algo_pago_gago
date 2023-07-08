package kh.programmers.삼각_달팽이;


class Solution {

    private int[][] triangle;

    private final int DOWN = 0;
    private final int RIGHT = 1;
    private final int UP = 2;
    private final int END = -1;

    private int dir = DOWN;

    private int maxNum = 0;

    public int[] solution(int n) {
        maxNum = (n * (n + 1)) / 2;
        triangle = new int[n][n];

        int[] answer = new int[maxNum];

        int num = 1;

        int i = 0;
        int j = 0;

        while (true) {
            triangle[i][j] = num;
            if (num == maxNum) {
                dir = END;
                break;
            }

            if (dir == DOWN) {
                if (i + 1 == triangle.length || triangle[i + 1][j] != 0) {
                    dir = RIGHT;
                }
                else {
                    i++;
                    num++;
                }
            }
            else if (dir == RIGHT) {
                if (j + 1 == triangle.length || triangle[i][j + 1] != 0) {
                    dir = UP;
                }
                else {
                    j++;
                    num++;
                }
            }
            else if (dir == UP) {
                if (i - 1 < 0 || j - 1 < 0 || triangle[i - 1][j - 1] != 0) {
                    dir = DOWN;
                }
                else {
                    i--;
                    j--;
                    num++;
                }
            }

        }

        int idx = 0;
        for (int v = 0; v < n; v++) {
            for (int w = 0; w < n; w++) {
                if (triangle[v][w] == 0) {
                    break;
                }
                answer[idx++] = triangle[v][w];
            }
        }

        return answer;
    }
}
public class Main {
    public static void main(String[] args) {

    }
}
