package 剑指offer专项突击版;

/**
 * Title: 爬楼梯的最少成本088
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-01
 */
public class 爬楼梯的最少成本088 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[3];
        for (int i = 2; i <= len; i++) {
            dp[i % 3] = Math.min(dp[(i - 1) % 3 ] + cost[i - 1], dp[(i - 2) % 3] + cost[i - 2]);
        }
        return dp[len % 3];
    }
}
