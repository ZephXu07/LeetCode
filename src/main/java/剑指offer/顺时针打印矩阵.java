package 剑指offer;

/**
 * Title: 顺时针打印矩阵
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-30
 */
public class 顺时针打印矩阵 {
    public int[] spiralOrder(int[][] matrix) {
        if (null == matrix || 0 == matrix.length) {
            return new int[]{};
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int index = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];
        while (true) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[bottom][i];
            }
            if (--bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        顺时针打印矩阵 res = new 顺时针打印矩阵();
        res.spiralOrder(matrix);
    }
}
