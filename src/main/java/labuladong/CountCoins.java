package labuladong;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: labuladong.CountCoins
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-09-21
 */
public class CountCoins {
    public static void main(String[] args) {
        List<Integer> coins = new ArrayList<>(3);
        coins.add(1);
        coins.add(2);
        coins.add(5);
        int amount = 15;
        int coinChange = coinChange(coins, amount);
        System.out.println(coinChange);

    }

    static int coinChange(List<Integer> coins, int amount) {
        // 数组大小为 amount + 1，初始值也为 amount + 1
        List<Integer> dp = new ArrayList<>(amount + 1);
        for (int i = 0; i < amount + 1; i++) {
            dp.add(amount + 1);
        }
        dp.set(0, 0);
        for (int i = 0; i < dp.size(); i++) {
            // 内层 for 在求所有子问题 + 1 的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp.set(i, Math.min(dp.get(i), 1 + dp.get(i - coin)));
            }
        }
        System.out.println(dp);
        return dp.get(amount) == amount + 1 ? -1 : dp.get(amount);
    }
}
