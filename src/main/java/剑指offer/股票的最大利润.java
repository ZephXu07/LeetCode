package 剑指offer;

/**
 * Title: 股票的最大利润
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-07
 */
public class 股票的最大利润 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
//        int[][] dp = new int[len][2];
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        for (int i = 1; i < len; i++) {
//            if (i - 1 == -1) {
//                dp[i][0] = 0;
//                dp[i][1] = -prices[i];
//            } else {
//                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, - prices[i]);
        }
//        return dp[len - 1][0];
        return dp_i_0;
    }
}
