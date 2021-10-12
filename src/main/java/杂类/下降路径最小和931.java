package 杂类;

/**
 * Title: 下降路径最小和931
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-12
 */
public class 下降路径最小和931 {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        int[][] dp = new int[2][len];

        for (int j = 0; j < len; j++) {
            dp[(len - 1) & 1][j] = matrix[len - 1][j];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    dp[i & 1][0] = Math.min(dp[(i + 1) & 1][0], dp[(i + 1) & 1][1])
                            + matrix[i][0];
                } else if (j == len - 1) {
                    dp[i & 1][len - 1] = Math.min(dp[(i + 1) & 1][len - 1], dp[(i + 1) & 1][len - 2])
                            + matrix[i][len - 1];
                } else {
                    dp[i & 1][j] = Math.min(dp[(i + 1) & 1][j + 1], Math.min(dp[(i + 1) & 1][j], dp[(i + 1) & 1][j - 1]))
                            + matrix[i][j];
                }
            }
        }
        int min = 10001;
        for (int j = 0; j < len; j++) {
            min = Math.min(min, dp[0][j]);
        }
        return min;

    }

    public static void main(String[] args) {
        下降路径最小和931 res = new 下降路径最小和931();
        int[][] m = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(res.minFallingPathSum(m));
    }
}
