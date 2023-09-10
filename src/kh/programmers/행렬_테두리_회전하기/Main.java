package kh.programmers.행렬_테두리_회전하기;

import java.util.*;

class Solution {

    public boolean moved;

    // 무조건 오른쪽이 첫 이동
    public int moveFirst(int[][] board, int[] pos, List<Integer> moveLs) {
        int i = pos[0];
        int j = pos[1];

        // 리턴값
        int nextNum = board[i][j + 1];
        // 오른쪽으로 숫자이동
        board[i][j + 1] = board[i][j];
        // 원래칸 빈칸으로
        board[i][j] = -1;

        // pos 이동
        pos[1]++;

        // 이동한 리스트에 add
        moveLs.add(board[i][j + 1]);
        moved = true;

        moved = true;
        return nextNum;
    }

    public int moveRight(int[][] board, int[] pos, List<Integer> moveLs, int nextNum) {
        int i = pos[0];
        int j = pos[1];

        // 리턴값
        int ret = board[i][j + 1];
        // 오른쪽으로 숫자이동
        board[i][j + 1] = nextNum;

        // pos 이동
        pos[1]++;

        // 이동한 리스트에 add
        moveLs.add(board[i][j + 1]);
        return ret;
    }
    public int moveDown(int[][] board, int[] pos, List<Integer> moveLs, int nextNum) {
        int i = pos[0];
        int j = pos[1];

        // 리턴값
        int ret = board[i + 1][j];
        // 아래쪽으로 숫자이동
        board[i + 1][j] = nextNum;

        // pos 이동
        pos[0]++;

        // 이동한 리스트에 add
        moveLs.add(board[i + 1][j]);

        return ret;
    }
    public int moveLeft(int[][] board, int[] pos, List<Integer> moveLs, int nextNum) {
        int i = pos[0];
        int j = pos[1];

        // 리턴값
        int ret = board[i][j - 1];
        // 왼쪽으로 숫자이동
        board[i][j - 1] = nextNum;

        // pos 이동
        pos[1]--;

        // 이동한 리스트에 add
        moveLs.add(board[i][j - 1]);

        return ret;
    }
    public int moveUp(int[][] board, int[] pos, List<Integer> moveLs, int nextNum) {
        int i = pos[0];
        int j = pos[1];

        // 리턴값
        int ret = board[i - 1][j];
        // 오른쪽으로 숫자이동
        board[i - 1][j] = nextNum;

        // pos 이동
        pos[0]--;

        // 이동한 리스트에 add
        moveLs.add(board[i - 1][j]);

        return ret;
    }


    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];
        // board 세팅
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = (i * columns) + j + 1;
            }
        }
        int idx = 0;

        for (int[] query : queries) {
            int nextNum = -1;
            int[] initPos = new int[2];
            int[] pos = new int[2];

            // 0 = 오른쪽, 1 = 아래, 2 = 왼쪽, 3 = 위로
            int dir = 0;

            moved = false;

            // 회전에 이용된 수 리스트
            List<Integer> moveLs = new ArrayList<>();

            pos[0] = query[0] - 1;
            pos[1] = query[1] - 1;
            initPos[0] = query[0] - 1;
            initPos[1] = query[1] - 1;

            // 회전
            while(true) {
                // 회전 종료조건
                if (moved && nextNum == -1) break;

                // 첫 이동
                if (nextNum == -1) nextNum = moveFirst(board, pos, moveLs);
                else {
                    if (dir == 0) nextNum = moveRight(board, pos, moveLs, nextNum);
                    else if (dir == 1) nextNum = moveDown(board, pos, moveLs, nextNum);
                    else if (dir == 2) nextNum = moveLeft(board, pos, moveLs, nextNum);
                    else if (dir == 3) nextNum = moveUp(board, pos, moveLs, nextNum);
                }

                // 이동 후 다음 루프 방향설정
                if (dir == 0 && pos[1] == query[3] - 1) {
                    // 오른쪽 -> 아래
                    dir = 1;
                }
                else if (dir == 1 && pos[0] == query[2] - 1){
                    // 아래 -> 왼쪽
                    dir = 2;
                }
                else if (dir == 2 && pos[1] == query[1] - 1) {
                    // 왼쪽 -> 위
                    dir = 3;
                }
            }

            Collections.sort(moveLs);
            answer[idx++] = moveLs.get(0);
        }


        return answer;
    }
}
public class Main {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        Solution s = new Solution();
        int[] solution = s.solution(rows, columns, queries);
        
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
