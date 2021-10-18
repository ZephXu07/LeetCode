package 杂类;

/**
 * Title: 零钱兑换322
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-18
 */
public class 零钱兑换322 {
    public int coinChange(int[] coins, int amount) {
        // 自底向上的动态规划
        if(coins.length == 0){
            return -1;
        }

        // dp[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount;i++){
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] < min) {
                    min = dp[i - coin] + 1;
                }
            }
            dp[i] = min;
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        零钱兑换322 res = new 零钱兑换322();
        System.out.println(res.coinChange(new int[]{2}, 3));
    }
}
