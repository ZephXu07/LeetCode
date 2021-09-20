package 每日一题;

/**
 * Title: 二维区域和检索矩阵不可变
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-02
 */
public class 二维区域和检索矩阵不可变 {
}
class NumMatrix {
    private int[][] pre;
    public NumMatrix(int[][] matrix) {
//        int row = matrix.length;
//        if (row > 0) {
//            int col = matrix[0].length + 1;
//            pre = new int[row][col];
//            for (int i = 0; i < row; i++) {
//                for (int j = 0; j < col - 1; j++) {
//                    pre[i][j + 1] = pre[i][j] + matrix[i][j];
//                }
//            }
//        }

        int row = matrix.length;
        if (row > 0) {
            int col = matrix[0].length;
            pre = new int[row + 1][col + 1];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    pre[i + 1][j + 1] = pre[i][j + 1] + pre[i + 1][j] - pre[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
//        int res = 0;
//        for (int i = row1; i <= row2; i++) {
//            res += pre[i][col2 + 1] - pre[i][col1];
//        }
//        return res;


        return pre[row2 + 1][col2 + 1] - pre[row1][col2 + 1] - pre[row2 + 1][col1] + pre[row1][col1];
    }
}