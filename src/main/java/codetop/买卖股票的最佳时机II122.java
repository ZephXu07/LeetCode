package codetop;

/**
 * Title: 买卖股票的最佳时机II122
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-06
 */
public class 买卖股票的最佳时机II122 {
    public int maxProfit(int[] prices) {
        /*
            贪心，因为不限次数，当天比前一天价格高的，就可以在前一天买入，第二天卖出
            即使第三天更高，但是第二天卖出买入不亏钱，继续买入，第三天再卖出
            同理遍历，直到结束
         */

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
