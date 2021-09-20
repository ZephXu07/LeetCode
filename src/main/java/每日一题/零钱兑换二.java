package 每日一题;

/**
 * Title: 零钱兑换二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-10
 */
public class 零钱兑换二 {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len; i++) {
            int coin = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (coin <= j) {
                    dp[i][j] = dp[i - 1][j] +  dp[i][j - coin];
                }
            }
        }
        return dp[len][amount];
    }
}
