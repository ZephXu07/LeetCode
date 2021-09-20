package codetop;

/**
 * Title: 二维数组中的查找
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-17
 */
public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        int[] xy = {row - 1, 0};
        while (xy[0] >= 0 && xy[1] < col) {
            if (matrix[xy[0]][xy[1]] == target) {
                return true;
            } else if (matrix[xy[0]][xy[1]] < target) {
                xy[1]++;
            } else {
                xy[0]--;
            }
        }
        return false;
    }
}
