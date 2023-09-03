package kjy.week_09;

import java.util.ArrayList;
import java.util.List;

public class 퍼즐조각채우기_84021 {
    private final int[][] MOVE = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int count;
    private int[] point = new int[2];

    public int solution(int[][] game_board, int[][] table) {
        List<Block> blanks = new ArrayList<>();
        List<Block> targets = new ArrayList<>();
        
        int length = game_board.length;
        int[][] _table = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                _table[i][j] = table[i][j] == 1 ? 0 : 1;
            }
        }

        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                if (game_board[y][x] == 0) {
                    int[][] temp = new int[length][length];
                    point[0] = x;
                    point[1] = y;
                    count = 0;
                    findBlock(point[0], point[1], temp, game_board);
                    blanks.add(new Block(count, point[0], point[1], temp));
                }

                if (_table[y][x] == 0) {
                    int[][] temp = new int[length][length];
                    point[0] = x;
                    point[1] = y;
                    count = 0;
                    findBlock(point[0], point[1], temp, _table);
                    targets.add(new Block(count, point[0], point[1], temp));
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < blanks.size(); i++) {
            Block blank = blanks.get(i);
            for (int j = 0; j < targets.size(); j++) {
                Block target = targets.get(j);

                if (target.fitBlock(blank)) {
                    answer += blank.count;
                    targets.remove(j);
                    break;
                }
            }
        }

        return answer;
    }

    private void findBlock(int x, int y, int[][] temp, int[][] map) {
        count++;
        map[y][x] = -1;
        temp[y][x] = 1;

        if (x < point[0]) {
            point[0] = x;
        }
        if (y < point[1]) {
            point[1] = y;
        }

        for (int[] m : MOVE) {
            int nextX = x + m[0];
            int nextY = y + m[1];

            if (0 <= nextX && nextX < map.length && 0 <= nextY && nextY < map.length) {
                if (map[nextY][nextX] == 0) {
                    findBlock(nextX, nextY, temp, map);
                }
            }
        }
    }
}

class Block implements Comparable<Block> {
    public Integer count;
    public int[][] arr;

    public Block(Integer count, int startX, int startY, int[][] map) {
        this.count = count;
        this.arr = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (startX + i < map.length && startY + j < map.length) {
                    arr[j][i] = map[startY + j][startX + i];
                }
            }
        }
    }

    public boolean fitBlock(Block block) {
        if (this.count != block.count) {
            return false;
        }

        int fit;

        for (int i = 0; i < 4; i++) {
            int[][] rotate = this.rotate(i);

            for (int x = 0; x < 6; x++) {
                for (int y = 0; y < 6; y++) {
                    fit = 0;

                    for (int m = 0; m < 6; m++) {
                        for (int n = 0; n < 6; n++) {
                            if (0 <= x + m && x + m < 6 && 0 <= y + n && y + n < 6) {
                                if (block.arr[n][m] == 1 && rotate[y + n][x + m] == 1) {
                                    fit++;
                                } else if (block.arr[n][m] == 0 && rotate[y + n][x + m] == 0) {
                                    continue;
                                } else {
                                    m = 6;
                                    n = 6;
                                }
                            }
                        }
                    }

                    if (fit == this.count) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public int[][] rotate(int i) {
        int[][] rotate = new int[6][6];
        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 6; y++) {
                if (i == 0) {
                    rotate[y][x] = this.arr[y][x];
                } else if (i == 1) {
                    rotate[y][x] = this.arr[x][5 - y];
                } else if (i == 2) {
                    rotate[y][x] = this.arr[5 - y][5 - x];
                } else if (i == 3) {
                    rotate[y][x] = this.arr[5 - x][y];
                }
            }
        }
        return rotate;
    }

    @Override
    public int compareTo(Block o) {
        return this.count.compareTo(o.count);
    }
}
