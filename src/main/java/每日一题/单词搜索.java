package 每日一题;

import codetop.单词接龙;

/**
 * Title: 单词搜索
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-03
 */
public class 单词搜索 {
    private final static int[][] DIRECTION = {{-1,0},{1,0},{0,-1},{0,1}};
    private char[][] board;
    private int row;
    private int col;
    private String word;
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        row = board.length;
        col = board[0].length;
        this.word = word;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited = new boolean[row][col];
                    if (findWord(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean findWord (int x, int y, int inx) {
        if (!isValid(x, y) || visited[x][y] || board[x][y] != word.charAt(inx)) {
            return false;
        }
        if (inx == word.length() - 1) {
            return true;
        }
        visited[x][y] = true;
        boolean res = false;
        for (int[] d : DIRECTION) {
            int nx = x + d[0];
            int ny = y + d[1];
            res |= findWord(nx, ny, inx + 1);
        }
        visited[x][y] = false;
        return res;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public static void main(String[] args) {
        单词搜索 res = new 单词搜索();
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
//        String word = "SEE";
//        String word = "ABCB";
//        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
//        String word = "AAB";
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        String word = "ABCESEEEFS";
        System.out.println(res.exist(board, word));
    }
}
