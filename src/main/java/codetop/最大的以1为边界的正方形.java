package codetop;

/**
 * Title: 最大的以1为边界的正方形
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-14
 */
public class 最大的以1为边界的正方形 {
    public int largest1BorderedSquare(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][][] dp = new int[row + 1][col + 1][2];
        /*
            dp[i][j][0]  第 i 行 [0,j] 列 且以 j 结尾的连续 1 的长度
            dp[i][j][1]  第 j 列 [0,i] 行 且以 i 结尾的连续 1 的长度

         */

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    dp[i][j][0] = dp[i][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j][1] + 1;
                }
            }
        }
        /*
            枚举每个点为右下角的正方形
         */
        int res = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                for (int k = Math.min(dp[i][j][0], dp[i][j][1]); k >= 1; k--) {
                    /*
                        短的为边，枚举下边和右边连续 1 长度
                        判断对应的上边和左边是否有此长度的连续 1
                        找到了就停止，因为从大到小，找小的没意义
                     */
                    if (dp[i][j - k + 1][1] >= k && dp[i - k + 1][j][0] >= k) {
                        res = Math.max(res, k);
                        break;
                    }
                }
            }
        }

        return res * res;

    }
}
