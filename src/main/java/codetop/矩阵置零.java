package codetop;

/**
 * Title: 矩阵置零
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-28
 */
public class 矩阵置零 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flag = true;
                /*
                    标记第一列是否有 0
                 */
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
                /*
                    用第一列和第一行标记是否出现 0
                 */
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            /*
                从尾行开始每一行处理，防止第一行全为 0
             */
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    /*
                        列头行头为 0
                     */
                    matrix[i][j] = 0;
                }
            }
            if (flag) {
                /*
                    如果第一列原本有 0
                 */
                matrix[i][0] = 0;
            }
        }
    }
}
