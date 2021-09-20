package codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title: 八皇后
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-26
 */

public class 八皇后 {
    private int n;
    private char[][] board;
    private List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        res = new ArrayList<>();
        backtrack(0);
        return res;
    }

    private void backtrack (int x) {
        /*
            每次一行填一个，到达行长度则停止
         */
        if (x == n) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ans.add(new String(board[i]));
            }
            res.add(ans);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isQ(x, i)) {
                board[x][i] = 'Q';
                backtrack(x + 1);
                board[x][i] = '.';
            }
            /*
                回溯
             */
        }


    }



    private boolean isQ (int x, int y) {
        /*
            [0, x)列是否有其他皇后
         */
        for (int i = 0; i < x; i++) {
            if (board[i][y] == 'Q') {
                return false;
            }
        }
        int nx = x;
        int ny = y;
        while (nx >= 0 && ny >= 0) {
            /*
                右下角到左上角的对角线
             */
            if (board[nx][ny] == 'Q') {
                return false;
            }
            nx--;
            ny--;
        }

        nx = x;
        ny = y;
        while (nx >= 0 && ny < n) {
            /*
                左下角到右上角的对角线
             */
            if (board[nx][ny] == 'Q') {
                return false;
            }
            nx--;
            ny++;
        }
        return true;
    }

    public static void main(String[] args) {
        八皇后 res = new 八皇后();
        final List<List<String>> lists = res.solveNQueens(4);
        System.out.println(lists.size());
        for (List<String> l : lists) {
            for (String s : l) {
                System.out.println(s);
            }
            System.out.println("-----------");
        }
    }
}
