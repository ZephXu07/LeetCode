package 字节;

import java.util.*;

/**
 * Title: 零钱兑换二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-16
 */
public class 零钱兑换二 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }



    public static void main(String[] args) {
        零钱兑换二 res = new 零钱兑换二();
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(res.change(amount, coins));
    }
}
