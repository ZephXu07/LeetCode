package codetop;

/**
 * Title: 解数独
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-14
 */
public class 解数独 {
    private char[][] board;
    private int len;

    public void solveSudoku(char[][] board) {
        this.board = board;
        len = 9;
        backtrack(0, 0);
    }

    private boolean backtrack (int x, int y) {
        if (y == len) {
            return backtrack(x + 1, 0);
        }
        if (x == len) {
            return true;
        }
        for (int i = x; i < len; i++) {
            for (int j = y; j < len; j++) {
                if (board[i][j] != '.') {
                    return backtrack(i ,j + 1);
                }

                for (char c = '1'; c <= '9'; c++) {
                    if (!isExist(i, j, c)) {
                        continue;
                    }

                    board[i][j] = c;
                    if (backtrack(i, j + 1)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return false;
    }

    private boolean isExist (int x, int y, char c) {
        int nx = x / 3 * 3;
        int ny = y / 3 * 3;
        for (int i = 0; i < len; i++) {
            if (board[x][i] == c) {
                return false;
            }
            if (board[i][y] == c) {
                return false;
            }
            if (board[nx + i / 3][ny + i % 3] == c) {
                return false;
            }
        }
        return true;
    }


}
