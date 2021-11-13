package 每日一题;

import labuladong.Solution;

/**
 * Title: 猜数字大小II375
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-12
 */
public class 猜数字大小II375 {
    public int getMoneyAmount(int n) {
        /*
            https://leetcode-cn.com/problems/
            guess-number-higher-or-lower-ii/solution/
            cai-shu-zi-da-xiao-ii-by-leetcode-soluti-a7vg/
         */
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = k + Math.max(dp[i][k - 1], dp[k + 1][j]);
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n];
    }
}
