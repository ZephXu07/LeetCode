package codetop;

import 每日一题.粉刷房子三;

/**
 * Title: 粉刷房子256
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-23
 */
public class 粉刷房子256 {
    public int minCost (int[][] costs) {
        if (null == costs || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        /*
            如果当前的房子要用红色刷，则上一个房子只能用绿色或蓝色来刷，
            那么要求刷到当前房子，
            且当前房子用红色刷的最小花费就等于当前房子用红色刷的钱加上
            刷到上一个房子用绿色和刷到上一个房子用蓝色中的较小值，
            这样当算到最后一个房子时，只要取出三个累计花费的最小值即可

            而当只有一间房子时，其花费就是涂成的颜色的花费
         */
        int len = costs.length;
        int[][] dp = new int[len][3];
        /*
            从 0 涂到第 i 间房子时是 j 颜色的最小花费是多少
         */
        dp[0] = costs[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(Math.min(dp[len - 1][0], dp[len - 1][1]), dp[len - 1][2]);
    }

    public static void main(String[] args) {
        粉刷房子256 res = new 粉刷房子256();
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(res.minCost(costs));
    }
}
