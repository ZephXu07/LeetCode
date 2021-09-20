package 每日一题;

/**
 * Title: 转置矩阵
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-25
 */
public class 转置矩阵 {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
