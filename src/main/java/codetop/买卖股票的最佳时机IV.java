package codetop;

/**
 * Title: 买卖股票的最佳时机IV
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-22
 */
public class 买卖股票的最佳时机IV {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        /*
            一天买了卖或者卖了买都对当天没影响
            即当天多次买卖同一股票没有影响
            假设买入算一次交易，则 len / 2 次交易是最多
            而 k > len / 2 后的交易次数是没有影响的
            所以 k 取值适当缩小
         */
        k = Math.min(k, len / 2);

        int[][][] dp = new int[len][2][k + 1];
        /*
            dp[i][j][k] 第 i 天不持有(0) 或持有(1) 股票且最多交易 k 次时的最大利益

            第 i 天持有股票时
                如果是第 i - 1 天也持有股票时，第 i 天与第 i - 1 天没有变化
                    dp[i][1][k] = dp[i - 1][1][k]
                如果是第 i - 1 天没持有股票时，第 i 天需要买入
                    dp[i][1][k] = dp[i - 1][0][k - 1] - prices[i]
                取最大值

            第 i 天不持有股票时
                如果第 i - 1 天也不持有股票时，第 i 天与第 i - 1 天也没有变化
                    dp[i][0][k] = dp[i - 1][0][k]
                如果是第 i - 1 天持有股票时，第 i 天需要卖出
                    dp[i][0][k] = dp[i - 1][1][k] + prices[i]
                取最大值
        */

        for (int i = 1; i <= k; i++) {
            dp[0][0][i] = 0;
            dp[0][1][i] = - prices[0];
        }
        /*
            当交易次数为 0 时，持有或不持有股票利益都为 0
            初始化
            第 0 天不持有股票时利益为0，无论交易多少次（即最后还是不持有股票）利益都是 0
            第 0 天持有股票时利益为 -prices[0]，无论交易多少次（即最后还是持有股票）利益都是 -prices[0]
         */

        for (int i = 1; i < len; i++) {
            for (int o = 1; o <= k; o++) {
                dp[i][1][o] = Math.max(dp[i - 1][1][o], dp[i - 1][0][o - 1] - prices[i]);
                dp[i][0][o] = Math.max(dp[i - 1][0][o], dp[i - 1][1][o] + prices[i]);
            }
        }
        return dp[len - 1][0][k];
        /*
            第 len - 1 天不持有股票肯定比持有股票利益多
            而交易次数越多，利益大于等于交易次数少的
         */
    }
}
