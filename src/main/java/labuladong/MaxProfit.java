package labuladong;

/**
 * Title: labuladong.MaxProfit
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-20
 */
public class MaxProfit {

    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
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

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
//        int[][] dp = new int[len][2];
        int tmp;
        for (int i = 1; i < len; i++) {
//            if (i - 1 == -1) {
//                dp[i][0] = 0;
//                dp[i][1] = -prices[i];
//            } else {
//                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
//            }
            tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);

        }
//        return dp[len - 1][0];
        return dp_i_0;
    }

    public int maxProfit3(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        int tmp = 0;
        int pre_i_0 = 0;
//        int[][] dp = new int[len][2];
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
//        dp[1][1] = Math.max(dp[0][1], - prices[0]);
        for (int i = 1; i < len; i++) {
            tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, pre_i_0 - prices[i]);
            pre_i_0 = tmp;
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);

        }
//        return dp[len - 1][0];
        return dp_i_0;
    }

    public int maxProfit4(int[] prices, int fee) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0] - fee;
//        int[][] dp = new int[len][2];
        int tmp;
        for (int i = 1; i < len; i++) {
//            if (i - 1 == -1) {
//                dp[i][0] = 0;
//                dp[i][1] = -prices[i];
//            } else {
//                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
//            }
            tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i] - fee);

        }
//        return dp[len - 1][0];
        return dp_i_0;
    }

    public int maxProfit5(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
//        int maxK = 2;
//        int[][][] dp = new int[len][maxK + 1][2];
//        for (int i = 0; i < len; i++) {
//            if (i - 1 == -1) {
//                dp[i][2][0] = 0;
//                dp[i][2][1] = -prices[i];
//                dp[i][1][0] = 0;
//                dp[i][1][1] = -prices[i];
//            } else {
//                dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
//                dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
//                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
//                dp[i][1][1] = Math.max(dp[i - 1][1][1], - prices[i]);
//            }
//        }
//        return dp[len - 1][maxK][0];
        int dp_i_1_0 = 0;
        int dp_i_1_1 = Integer.MIN_VALUE;
        int dp_i_2_0 = 0;
        int dp_i_2_1 = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + prices[i]);
            dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - prices[i]);
            dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + prices[i]);
            dp_i_1_1 = Math.max(dp_i_1_1, - prices[i]);
        }
        return dp_i_2_0;
    }


    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        MaxProfit maxProfit = new MaxProfit();
        int i = maxProfit.maxProfit5(prices);
        System.out.println(i);
    }

    public int maxProfitAnyInteger(int k, int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        if (k > len / 2) {
            return maxProfitInfinity(prices);
        }
        int[][][] dp = new int[len][k + 1][2];
        for (int i = 0; i < len; i++) {
            for (int j = k; j >= 1; j--) {
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        return dp[len - 1][k][0];
    }

    public int maxProfitInfinity(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        int tmp;
        for (int i = 1; i < len; i++) {
            tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);

        }
        return dp_i_0;
    }
}
