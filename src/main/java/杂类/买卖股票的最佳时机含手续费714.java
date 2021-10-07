package 杂类;

/**
 * Title: 买卖股票的最佳时机含手续费714
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-07
 */
public class 买卖股票的最佳时机含手续费714 {
    public int maxProfit(int[] prices, int fee) {
        /*
           贪心：
            情况一：收获利润的这一天并不是收获利润区间里的最后一天（不是真正的卖出，相当于持有股票），
                所以后面要继续收获利润。
            情况二：前一天是收获利润区间里的最后一天（相当于真正的卖出了），
                今天要重新记录最小价格了。
            情况三：不作操作，保持原有状态（买入，卖出，不买不卖）
         */
        int res = 0;
        int min = prices[0];
        /*
            记录最低价格
         */
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                /*
                    情况二：相当于买入
                 */
                min = prices[i];
            }

            if (prices[i] >= min && prices[i] <= min + fee) {
                /*
                    情况三：保持原有状态（因为此时买则不便宜，卖则亏本）
                 */
                continue;
            }

            if (prices[i] > min + fee) {
                /*
                    计算利润，可能有多次计算利润，最后一次计算利润才是真正意义的卖出
                 */
                res += prices[i] - min - fee;
                min = prices[i] - fee;
                /*
                    因为如果还在收获利润的区间里，
                    表示并不是真正的卖出，
                    而计算利润每次都要减去手续费，
                    所以要让min = prices[i] - fee;
                    这样在明天收获利润的时候，才不会多减一次手续费
                    第二天
                    prices[i] - min - fee
                    = prices[i] - (prices[i - 1] - fee) - fee ;
                    = prices[i] - prices[i - 1]
                 */
            }
        }

        return res;
    }
}
