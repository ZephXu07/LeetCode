package 剑指offer专项突击版;

/**
 * Title: 最少的硬币数目103
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-04
 */
public class 最少的硬币数目103 {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }

        /*
            dp[i]的值： 表示的凑成总金额为 i 所需的最少的硬币个数
         */
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount;i++){
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] < min) {
                    /*
                        金额- 当前硬币 = 余额
                        凑成余额的硬币数小于等于 min
                        则可以再更新，虽然可能 dp[i - coin] = min - 1
                        但还是相等了，所以此处无所谓
                     */
                    min = dp[i - coin] + 1;
                }
            }
            dp[i] = min;
            /*
                记录下凑成金额 i 的最少硬币数
             */
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        /*
            判断是否能凑成
         */
    }

}
