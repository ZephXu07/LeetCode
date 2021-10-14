package 杂类;

/**
 * Title: 矩阵区域和1314
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-14
 */
public class 矩阵区域和1314 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] pre = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pre[i + 1][j + 1] = pre[i][j + 1] + pre[i + 1][j] - pre[i][j] + mat[i][j];
            }
        }
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int i1 = Math.max(0, i - k);
                int j1 = Math.max(0, j - k);
                int i2 = Math.min(i + k, row - 1);
                int j2 = Math.min(j + k, col - 1);
                res[i][j] = pre[i2 + 1][j2 + 1] - pre[i1][j2 + 1] - pre[i2 + 1][j1] + pre[i1][j1];
            }
        }
        return res;
    }
}
