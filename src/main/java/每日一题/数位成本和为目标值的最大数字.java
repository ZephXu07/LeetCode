package 每日一题;

import java.util.Arrays;

/**
 * Title: 数位成本和为目标值的最大数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-13
 */
public class 数位成本和为目标值的最大数字 {
    public String largestNumber(int[] cost, int target) {
        /*
            dp[i][j]
            坐标为 i ，表示由[1, i]自由选择
            [1, 9]遍历到 i 时，成本为 cost[i - 1]，因为数组下标是 0 开始的，但数是从 1 开始的
            坐标为 j，表示成本花费有 j
            值表示数多少位
            题目要求花费需要刚好为 target 才返回最大的数，否则是 0
            于是成本无法刚好为 j ，则值为 - INF，不用组合最大的数，直接返回 0
            成本刚好为 j 时，则正常
            题目说明无数位 0 ，于是当坐标为 0 时，除了成本为 0 时，数位为 0 ，其他成本时值数位都设置为 - INF


            from[i][j] 表示 dp[i][j] 的 j 的上一个状态的 j 是多少，即上个成本是什么，
            而 i 不需要记录，i 只能从 i，i - 1 转移来的

           对于第 i 个数，，选这个数的成本 c = cost[i - 1]，当 i <= j时，可进行选择
           当成本 j < c 时，是怎么也选不了的
           此时不选  dp[i][j] = d[i - 1][j]
                    from[i][j] = j
            j >= c 时是可选的
           此时选
               还要进行讨论：dp[i - 1][j] 与 dp[i][j - c] + 1 的大小

                dp[i - 1][j] > dp[i][j - c] + 1 时，不选会更好，回到上面不选的情况
                        dp[i][j] = dp[i - 1][j];
                        from[i][j] = j;

                dp[i - 1][j] <= dp[i][j - c] + 1 时
                        dp[i][j] = dp[i][j - c] + 1;
                        from[i][j] = j - c;

                且两个相等即 dp[i][j - c] + 1 ==  d[i - 1][j]时，选择dp[i][j - c] + 1
                因为 i > i - 1，i 是[1, 9]，才能组合更大的数


            因为前面已经设置了无法准确到达成本 j 时值为 -INF，根据题目的值，再怎么计算都无法大于 0 ，此时直接返回 "0"

            根据dp[9][target]来组合最大的数

            i 与 j 进行判断，前提条件有
            i [1, 9]，为了得到更大是从 9 --> 1

            设 x == from[i][j]
            若 x == j, from[i][j] 表示 dp[i][j] 从 dp[i-1][j] 转移而来，
                即没有选择 i 这个数，i 则减一
           若 x != j, from[i][j] 表示 dp[i][j] 从 dp[i][x] 转移而来，
                即选择了i这个数，此时则要把 i 加入结果，且j = from[i][j]，找到转移之前的状态，进行下一次判断
         */
        int[][] dp = new int[10][target + 1];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        dp[0][0] = 0;

        int[][] from = new int[10][target + 1];
        for (int i = 1; i <= 9; i++) {
            int c = cost[i - 1];
            for (int j = 0; j <= target; j++) {
                if (j < c) {
                    dp[i][j] = dp[i - 1][j];
                    from[i][j] = j;
                } else {
                    if (dp[i - 1][j] <= dp[i][j - c] + 1) {
                        dp[i][j] = dp[i][j - c] + 1;
                        from[i][j] = j - c;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                        from[i][j] = j;
                    }
                }
            }
        }
        if (dp[9][target] < 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        int i = 9;
        int j = target;
        while (i > 0) {
            if (from[i][j] == j) {
                i--;
            } else {
                res.append(i);
                j = from[i][j];
            }
        }
        return res.toString();
    }

    public String largestNumber1(int[] cost, int target) {
        /*
            dp[i][j]
            坐标为 i ，表示由[1, i]自由选择
            [1, 9]遍历到 i 时，成本为 cost[i - 1]，因为数组下标是 0 开始的，但数是从 1 开始的
            坐标为 j，表示成本花费有 j
            值表示数多少位
            题目要求花费需要刚好为 target 才返回最大的数，否则是 0
            于是成本无法刚好为 j ，则值为 - INF，不用组合最大的数，直接返回 0
            成本刚好为 j 时，则正常
            题目说明无数位 0 ，于是当坐标为 0 时，除了成本为 0 时，数位为 0 ，其他成本时值数位都设置为 - INF


            from[i][j] 表示 dp[i][j] 的 j 的上一个状态的 j 是多少，即上个成本是什么，
            而 i 不需要记录，i 只能从 i，i - 1 转移来的

           对于第 i 个数，，选这个数的成本 c = cost[i - 1]，当 i <= j时，可进行选择
           当成本 j < c 时，是怎么也选不了的
           此时不选  dp[i][j] = d[i - 1][j]
                    from[i][j] = j
            j >= c 时是可选的
           此时选
               还要进行讨论：dp[i - 1][j] 与 dp[i][j - c] + 1 的大小

                dp[i - 1][j] > dp[i][j - c] + 1 时，不选会更好，回到上面不选的情况
                        dp[i][j] = dp[i - 1][j];
                        from[i][j] = j;

                dp[i - 1][j] <= dp[i][j - c] + 1 时
                        dp[i][j] = dp[i][j - c] + 1;
                        from[i][j] = j - c;

                且两个相等即 dp[i][j - c] + 1 ==  d[i - 1][j]时，选择dp[i][j - c] + 1
                因为 i > i - 1，i 是[1, 9]，才能组合更大的数


            因为前面已经设置了无法准确到达成本 j 时值为 -INF，根据题目的值，再怎么计算都无法大于 0 ，此时直接返回 "0"

            根据dp[9][target]来组合最大的数

            i 与 j 进行判断，前提条件有
            i [1, 9]，为了得到更大是从 9 --> 1

            设 x == from[i][j]
            若 x == j, from[i][j] 表示 dp[i][j] 从 dp[i-1][j] 转移而来，
                即没有选择 i 这个数，i 则减一
           若 x != j, from[i][j] 表示 dp[i][j] 从 dp[i][x] 转移而来，
                即选择了i这个数，此时则要把 i 加入结果，且j = from[i][j]，找到转移之前的状态，进行下一次判断
         */
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;


        for (int i = 1; i <= 9; i++) {
            int c = cost[i - 1];
            for (int j = c; j <= target; j--) {
                dp[j] = Math.max(dp[j], dp[j - c] + 1);
            }
        }
        if (dp[target] < 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for (int i = 9, j = target; i >= 1; i++) {
            for (int c = cost[i - 1]; j >= c && dp[j] == dp[j - c] + 1;j -= c) {
                res.append(i);
            }
        }
        return res.toString();
        /*
              二维变一维不懂为什么这次是正向遍历……
              from被移除，根据 dp[j] == dp[j - c] + 1 判断，是的话证明转移而来，则添加 i，
              一开始 j = target 只初始化是刚好成本从这样算起，后面得到正确的转移状态才继续循环，
              否则跳出后再根据 j 的新值和 c 的值继续判断
         */

    }
}
