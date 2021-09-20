package labuladong;

/**
 * Title: labuladong.SurroundedRegions
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-20
 */
public class SurroundedRegions {
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
        }
        for (int i = 1; i < c - 1; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[r - 1][i] == 'O') {
                dfs(board, r - 1, i);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        dfs(board, r - 1, c);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
        dfs(board, r, c + 1);
    }


    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        SurroundedRegions regions = new SurroundedRegions();
        regions.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
