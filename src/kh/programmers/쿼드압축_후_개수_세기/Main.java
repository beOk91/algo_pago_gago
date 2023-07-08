package kh.programmers.쿼드압축_후_개수_세기;


class Solution {
    int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];

        divide(0, 0, arr.length, arr);

        return answer;
    }

    private void divide(int startI, int startJ, int n, int[][] arr) {
        // 1. 한 칸 minimum status || 전체 같은 개수
        if (n == 0 || check(startI, startJ, n, arr)) {
            answer[arr[startI][startJ]]++;
            return;
        }

        divide(startI, startJ, n / 2, arr);
        divide(startI, startJ + n / 2, n / 2, arr);
        divide(startI + n / 2, startJ, n / 2, arr);
        divide(startI + n / 2, startJ + n / 2, n / 2, arr);
    }

    private boolean check(int startI, int startJ, int n, int[][] arr) {
        int checkNum = arr[startI][startJ];


        for (int i = startI; i < startI +  n; i++) {
            for (int j = startJ; j < startJ + n; j++) {
                if (arr[i][j] != checkNum) {
                    return false;
                }
            }
        }

        return true;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};

//        int[][] arr = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};


        int[] solution = s.solution(arr);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

}
