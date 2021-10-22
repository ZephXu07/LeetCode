package 杂类;

/**
 * Title: 买卖股票的最佳时机121
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-22
 */
public class 买卖股票的最佳时机121 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            /*
                贪心
                寻找左侧最低
                同时当前计算与左侧最低的差值
                取最大
             */
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
