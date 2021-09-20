package codetop;

/**
 * Title: 统计全为1的正方形子矩阵
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-29
 */
public class 统计全为1的正方形子矩阵 {
    public int countSquares(int[][] matrix) {
        int count = 0;
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return count;
        }
        /*
            dp[i][j] 表示以 i,j为下标的只包含 1 的正方形的边长最长是多少，
            同时也是以 i,j为下标的只包含 1 的正方形的个数，因为边长为 3 的正方形里面有有边长 1 和 2 的正方形
            当 matrix[i][j] 为 0 时，此时不只包含 1 了，不能构成正方形，边长为 0
            当 matrix[i][j] 为 1 时，
                如果 i == 0 或者 j == 0，
                    表示在第一行或者第一列，此时即使为 1 ，边长最长为 1
                否则有
                    因为我们是从上往下，从左往右遍历的，
                    到 i, j 时，i - 1,j   i, j - 1    i - 1, j - 1
                    为下标的只包含 1 的正方形边长最大值我们是知道的
                    如果这三个值有一个为 0 ，
                        说明在 matrix[i][j] 周围的三个格子有一个为 0 ，
                        此时最大也就是自身的小格子，边长为 1
                   如果这三个值不为 0 ，画图吧，我解释不了……

         */

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1],
                                Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                }
                count += dp[i][j];
            }
        }
        return count;
    }
}
