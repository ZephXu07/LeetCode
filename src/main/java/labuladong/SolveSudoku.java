package labuladong;

/**
 * Title: labuladong.SolveSudoku
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-15
 */
public class SolveSudoku {


    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }
    private boolean backtrack(char[][] board, int x, int y) {
        int length = 9;
        if (length == y) {
            return backtrack(board, x + 1, 0);
        }
        if (length == x) {
            return true;
        }
        for (int i = x; i < length; i++) {
            for (int j = y; j < length; j++) {
                if ('.' != board[i][j]) {
                    return backtrack(board, i, j + 1);
                }
                for (char c = '1'; c <= '9'; c++) {
                    if (!isValid(board, i, j, c)) {
                        continue;
                    }

                    board[i][j] = c;
                    if (backtrack(board, i, j + 1)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return false;
    }
    private boolean isValid(char[][] board, int x, int y, char c) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[x][i] == c) {
                return false;
            }
            // 判断列是否存在重复
            if (board[i][y] == c) {
                return false;
            }
            // 判断 3 x 3 方框是否存在重复
            if (board[(x / 3) * 3 + i / 3][(y / 3) * 3 + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SolveSudoku sudoku = new SolveSudoku();
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        sudoku.solveSudoku(board);
        for (char[] c: board
             ) {
            for (char cc:c
                 ) {
                System.out.print(cc + "\t");
            }
            System.out.println();
        }
    }
}
