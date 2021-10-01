package 剑指offer专项突击版;

/**
 * Title: 二维子矩阵的和013
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-01
 */
public class 二维子矩阵的和013 {
}
class NumMatrix {

    private int[][] pre;
    public NumMatrix(int[][] matrix) {
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
        return pre[row2 + 1][col2 + 1] - pre[row1][col2 + 1] - pre[row2 + 1][col1] + pre[row1][col1];
    }
}
