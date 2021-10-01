package codetop;

/**
 * Title: 使用最小花费爬楼梯746
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-01
 */
public class 使用最小花费爬楼梯746 {
//    private int res;
//    public int minCostClimbingStairs(int[] cost) {
//        res = Integer.MAX_VALUE;
//        dfs(0, 0, cost);
//        dfs(1, 0, cost);
//        return res;
//    }
//
//    private void dfs (int cur, int count, int[] cost) {
//        if (cur >= cost.length) {
//            res = Math.min(res, count);
//            return;
//        }
//        dfs(cur + 1, count + cost[cur], cost);
//        dfs(cur + 2, count + cost[cur], cost);
//    }

//    public int minCostClimbingStairs(int[] cost) {
//        int len = cost.length;
//        int[] dp = new int[len + 1];
//        dp[0] = 0;
//        dp[1] = 0;
//        for (int i = 2; i <= len; i++) {
//            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
//        }
//        return dp[len];
//    }

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[3];
        for (int i = 2; i <= len; i++) {
            dp[i % 3] = Math.min(dp[(i - 1) % 3 ] + cost[i - 1], dp[(i - 2) % 3] + cost[i - 2]);
        }
        return dp[len % 3];
    }

}
