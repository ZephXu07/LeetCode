package codetop;

/**
 * Title: 扫雷游戏
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-13
 */
public class 扫雷游戏 {
    private int m;
    private int n;
    private char[][] board;
    private boolean[][] visited;
    private final int[] DIR = {-1, 0, 1, 0, -1};
    //上，右，下，左
    private final int[] OTHER = {-1, -1, 1, 1, -1};
    //左上、右上、右下、左下

    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        visited = new boolean[m][n];
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        } else {
            dfs(click[0], click[1]);
        }
        return this.board;
    }

    private void dfs (int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + DIR[i];
            int ny = y + DIR[i + 1];
            int nnx = x + OTHER[i];
            int nny = y + OTHER[i + 1];

            if (isValid(nx, ny) && board[nx][ny] == 'M') {
                count++;
            }
            if (isValid(nnx, nny) && board[nnx][nny] == 'M') {
                count++;
            }
        }

        if (count > 0) {
            board[x][y] = (char) ('0' + count);
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < 4; i++) {
                int nx = x + DIR[i];
                int ny = y + DIR[i + 1];
                int nnx = x + OTHER[i];
                int nny = y + OTHER[i + 1];

                if (isValid(nx, ny) && board[nx][ny] == 'E') {
                    dfs(nx, ny);
                }
                if (isValid(nnx, nny) && board[nnx][nny] == 'E') {
                    dfs(nnx, nny);
                }
            }
        }


    }

    private boolean isValid (int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        扫雷游戏 res = new 扫雷游戏();
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        };
        final char[][] chars = res.updateBoard(board, new int[]{3, 0});
        for (char[] cha: chars) {
            for (char c : cha) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }
    }
}
