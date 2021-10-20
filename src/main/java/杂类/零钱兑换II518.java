package 杂类;

/**
 * Title: 零钱兑换II518
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-20
 */
public class 零钱兑换II518 {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        /*
            前 i 种硬币凑成金额 j 的种类有多少
         */
        for (int i = 0; i <= len; i++) {
            /*
                凑成 0 金额，无论多少种硬币只有一种方案
             */
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len; i++) {
            int coin = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                /*
                    默认当前 i 种硬币凑成金额 j 是前 i - 1 种的方案
                 */
                if (coin <= j) {
                    /*
                        但当硬币面值小于金额时，
                        是前 i - 1 种硬币凑成金额 j
                        与 前 i 种硬币凑成金额 j - coin 的和
                     */
                    dp[i][j] = dp[i - 1][j] +  dp[i][j - coin];
                }
            }
        }
        return dp[len][amount];
    }
}
