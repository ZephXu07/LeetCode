package 程序员面试经典第六版;

import java.util.Arrays;

/**
 * Title: 零矩阵0108
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-05
 */
public class 零矩阵0108 {
    public void setZeroes(int[][] matrix) {
        boolean left = false;
        boolean right = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                left = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                right = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (left) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (right) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
