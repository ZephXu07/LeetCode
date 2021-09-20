package codetop;

/**
 * Title: 买卖股票的最佳时机三
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-16
 */
public class 买卖股票的最佳时机三 {
    public int maxProfit(int[] prices) {
        /*
            只能买卖两次，所以直接枚举状态
            什么都不做，当然为0
            只买一次，
            buy1 = max(buy1', -prices[i])
            买一次卖一次，
            sell1 = max(sell1',buy1'+prices[i])
            买一次卖一次再买
            buy2 = max(buy2',sell1'-prices[i])
            买一次卖一次再买再卖
            sell2 = max(sell2',buy2'+prices[i])

            由于当天买卖+-=0

            sell1 = max(sell1',buy1' + prices[i])
            如果 buy1 当天是买入股票，即 buy1 = buy1' - prices[i]
            如果 buy1 当天是什么都不做，即 buy1 = buy1
            所以没有影响

            初始化时，buy1 = -prices[0]
            sell1 买卖 -+ = 0
            buy1 = -+- = -prices[0]
            sell2 = -+-+ = 0

            而最后 sell 2 买卖买卖当然是最大的

         */
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
