package kjy.week_18;

public class 프렌즈4블록_17679 {
    public int solution(int m, int n, String[] board) {
        // 가장 아래 열이 0열이 되도록 재배열
        char[][] blocks = new char[m][n];
        for (int i = 0; i < m; i++) {
            blocks[i] = board[m - i - 1].toCharArray();
        }

        int answer = 0;
        while (true) {
            boolean[][] checked = new boolean[m][n];
            boolean find = false;

            // 제거할 블록 확인
            for (int y = 0; y < m - 1; y++) {
                for (int x = 0; x < n - 1; x++) {
                    char block = blocks[y][x];
                    if (block == ' ') {
                        continue;
                    }

                    if (blocks[y][x+1] == block &&
                        blocks[y+1][x] == block &&
                        blocks[y+1][x+1] == block) {
                        checked[y][x] = true;
                        checked[y][x+1] = true;
                        checked[y+1][x] = true;
                        checked[y+1][x+1] = true;
                        find = true;
                    }
                }
            }

            // 블록 제거
            if (!find) {
                break;
            }

            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    if (checked[y][x]) {
                        blocks[y][x] = ' ';
                        answer++;
                    }
                }
            }

            // 블록 정렬
            for (int y = 0; y < m - 1; y++) {
                for (int x = 0; x < n; x++) {
                    char bottom = blocks[y][x];
                    if (bottom != ' ') {
                        continue;
                    }

                    for (int w = y + 1; w < m; w++) {
                        char top = blocks[w][x];
                        if (top == ' ') {
                            continue;
                        }

                        blocks[y][x] = top;
                        blocks[w][x] = ' ';
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
