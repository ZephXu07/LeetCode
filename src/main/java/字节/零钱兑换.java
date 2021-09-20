package 字节;

import java.util.Arrays;

/**
 * Title: 零钱兑换
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-16
 */
public class 零钱兑换 {
//    private int res;
//    public int coinChange(int[] coins, int amount) {
//        if (amount == 0) {
//            return 0;
//        }
//        Arrays.sort(coins);
//        int high = coins.length - 1;
//        int tmp;
//        for (int i = 0; i < coins.length / 2; i++) {
//            tmp = coins[i];
//            coins[i] = coins[high - i];
//            coins[high - i] = tmp;
//        }
//        res = Integer.MAX_VALUE;
//        coinChange(coins, amount, 0, 0);
//        return res == Integer.MAX_VALUE ? -1 : res;
//    }
//
//    private void coinChange(int[] coins,int amount, int inx, int count) {
//        if (amount == 0) {
//            res = Integer.min(res, count);
//            return;
//        }
//        if (inx == coins.length) {
//            return;
//        }
//        for (int i = amount / coins[inx]; i >= 0 && i + count < res; i--) {
//            coinChange(coins, amount - i * coins[inx], inx + 1, count + i);
//        }
//    }

//    private int[] memo;
//    public int coinChange(int[] coins, int amount) {
//        if(coins.length == 0){
//            return -1;
//        }
//        memo = new int[amount];
//
//        return findWay(coins,amount);
//    }
//    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
//    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
//    public int findWay(int[] coins,int amount){
//        if(amount < 0){
//            return -1;
//        }
//        if(amount == 0){
//            return 0;
//        }
//        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
//        // 直接的返回memo[n] 的最优值
//        if(memo[amount-1] != 0){
//            return memo[amount-1];
//        }
//        int min = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            int res = findWay(coins, amount - coin);
//            if (res >= 0 && res < min) {
//                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
//            }
//        }
//        memo[amount-1] = (min == Integer.MAX_VALUE ? -1 : min);
//        return memo[amount-1];
//    }


    public int coinChange(int[] coins, int amount) {
        // 自底向上的动态规划
        if(coins.length == 0){
            return -1;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount+1];
        memo[0] = 0;
        for(int i = 1; i <= amount;i++){
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && memo[i - coin] < min) {
                    min = memo[i - coin] + 1;
                }
            }
            // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
            memo[i] = min;
        }

        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }


    public static void main(String[] args) {
        零钱兑换 res = new 零钱兑换();
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.println(res.coinChange(coins, amount));
    }
}
