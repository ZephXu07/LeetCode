package codetop;

/**
 * Title: 被围绕的区域
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-30
 */
public class 被围绕的区域 {
    public void solve(char[][] board) {
        if (null == board) {
            return;
        }
        int r = board.length;
        if (0 == r) {
            return;
        }
        int c = board[0].length;
        for (int i = 0; i < r; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][c - 1] == 'O') {
                dfs(board, i, c - 1);
            }
            /*
                处理边界的列
             */
        }
        for (int i = 1; i < c - 1; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[r - 1][i] == 'O') {
                dfs(board, r - 1, i);
            }
            /*
                处理边界的行
             */
        }
        /*
            行列与边界相连即及上下左右相连的才不会被打叉
         */
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'T') {
                    /*
                        被标记的地方，回归原样
                     */
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    /*
                        打叉
                     */
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            /*
                不符合矩形，或者原来就是×
             */
            return;
        }
        board[r][c] = 'T';
        /*
            标记
         */
        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
        /*
            寻找直接间接相连的上下左右
         */
    }
}
