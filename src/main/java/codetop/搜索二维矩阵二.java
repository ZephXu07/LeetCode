package codetop;

/**
 * Title: 搜索二维矩阵二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-22
 */
public class 搜索二维矩阵二 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int m = row - 1;
        int n = 0;
        while (m >= 0 && n < col) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                m--;
            } else {
                n++;
            }
        }
        return false;
    }
}
