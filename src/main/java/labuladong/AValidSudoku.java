package labuladong;

/**
 * Title: labuladong.AValidSudoku
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-09-12
 */
public class AValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        byte[][] rows = new byte[9][9];
        byte[][] columns = new byte[9][9];
        byte[][] boxes = new byte[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                byte x = (byte) (board[i][j] - '1');
                if(x >= 0 && x <= 9){
                    rows[i][x]++;
                    columns[j][x]++;
                    int index = i / 3 * 3 + j / 3;
                    boxes[index][x]++;
                    if(rows[i][x]>1 || columns[j][x]>1 || boxes[index][x] > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {  {'8','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'} };
        boolean validSudoku = new AValidSudoku().isValidSudoku(board);
        System.out.println(validSudoku);
    }
}
