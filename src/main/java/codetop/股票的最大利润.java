package codetop;

/**
 * Title: 股票的最大利润
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-02
 */
public class 股票的最大利润 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = prices[0];
        int res = 0;
        for (int p : prices) {
            if (p < min) {
                res = Math.max(res, max - min);
                min = p;
                max = p;
            } else if (p > max){
                res = Math.max(p - min, res);
                max = p;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        股票的最大利润 res = new 股票的最大利润();
        System.out.println(res.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(res.maxProfit(new int[]{7, 6,4,3,1}));
    }
}
