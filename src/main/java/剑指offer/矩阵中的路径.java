package 剑指offer;

import java.util.LinkedList;

/**
 * Title: 矩阵中的路径
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-29
 */
public class 矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        StringBuilder track = new StringBuilder();
        char[] target = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == target[0]) {
                    if (backtrack(board, target, i, j, track)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, char[] target, int x, int y, StringBuilder track) {
        if (target.length == track.length()) {
            return track.toString().equals(new String(target));
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '*') {
            return false;
        }
        char c = target[track.length()];
        boolean res = false;
        if (board[x][y] == c) {
            board[x][y] = '*';
            track.append(c);
            res = backtrack(board, target, x - 1, y, track)|| backtrack(board, target, x + 1, y, track)
                    || backtrack(board, target, x, y - 1, track) || backtrack(board, target, x, y + 1, track);
            track.deleteCharAt(track.length() - 1);
            board[x][y] = c;
        }
        return res;
    }

    public static void main(String[] args) {
//        char[][] board = {  {'A','B','C','E'},
//                            {'S','F','C','S'},
//                            {'A','D','E','E'}};
//        char[][] board = {  {'a', 'b'},
//                            {'c', 'd'}
//        };
        char[][] board = {  {'C','A','A'},
                            {'A','A','A'},
                            {'B','C','D'},
        };
//        char[][] board = {  {'a'}};
//        String word = "a";
//        String word = "ABCCED";
//        String word = "abcd";
        String word = "AAB";
        矩阵中的路径 track = new 矩阵中的路径();
        System.out.println(track.exist(board, word));
    }
}
