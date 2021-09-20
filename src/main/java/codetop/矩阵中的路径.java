package codetop;

/**
 * Title: 矩阵中的路径
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-03
 */
public class 矩阵中的路径 {
    private final static int[][] DIRECTION = {{-1,0},{1,0},{0,-1},{0,1}};
    private char[][] board;
    private int row;
    private int col;
    private String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        row = board.length;
        col = board[0].length;
        this.word = word;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (findWord(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean findWord (int x, int y, int inx) {
        if (!isValid(x, y) || board[x][y] == '*' || board[x][y] != word.charAt(inx)) {
            return false;
        }
        if (inx == word.length() - 1) {
            return true;
        }
        char tmp = board[x][y];
        board[x][y] = '*';
        boolean res = false;
        for (int[] d : DIRECTION) {
            int nx = x + d[0];
            int ny = y + d[1];
            res = findWord(nx, ny, inx + 1);
            if (res) {
                break;
            }
        }
        board[x][y] = tmp;
        return res;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
