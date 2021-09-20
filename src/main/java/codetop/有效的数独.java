package codetop;

/**
 * Title: 有效的数独
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-02
 */
public class 有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];
        /*
            行，哪个数字
            列，哪个数字
            九宫格，哪个数字
         */
        int index;
        /*
            第几个九宫格
         */
        int num;
        /*
            哪个数字
         */
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                num = board[i][j] - '0';
                if (num >= 1 && num <= 9) {
                    index = i / 3 * 3 + j / 3;
                    row[i][num] ++;
                    col[j][num] ++;
                    box[index][num] ++;
                    /*
                        记录行、列、九宫格数字出现多少次
                     */
                    if (row[i][num] > 1 || col[j][num] > 1 || box[index][num] > 1) {
                        /*
                            超过 1 次则数独无效，返回
                         */
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
