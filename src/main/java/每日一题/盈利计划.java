package 每日一题;

/**
 * Title: 盈利计划
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-09
 */
public class 盈利计划 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        /*
            dp[i][j][k]
            在最多工作 i 种时随意选择时，在选择的人数最大为 j，获得的利润至少为 k，值为计划数
            (从 1 开始数，即 0 为不使用到工作、人数这些)

            初始化，当 0 种工作，人数为 0 ，利润为 0 只有一种计划
            同理，其实人数 j 从 0 到 n ，而工作数为 0 ，利润为 0 的计划都是一种

            对于 i 项工作，即数组中的 i-1工作
            有两种情况，能完成与不能完成
            完成的条件是这项工作的需要的人数 group[i-1] person 小于 此时的最大人数 j
            不能完成，当然是计划数等于没有这一项工作 i - 1时的计划数，而 最多人数 j 和 至少利润 k 是不变的

            能完成的话，没有这一项工作 i - 1 的计划数加上新的计划数
            新的计划数是没有这一项工作i时  i - 1 项工作，最多人数当然是现在的最大人数 j 减去工作需要的人数
            即 j - person；至少的利润是现在至少利润 k 减去 这项工作的利润与 0 的比较的最大值
           选择 k - money 即 k - money >= 0
           代表前面 i - 1项工作有部分被选择了或者 i-1 项工作的利润与当前项工作的利润相等
            选择了 0 ，则代表 k - money < 0，即这项工作的利润已经至少是 k 之上了，前面的工作其实没被选择，没有提供利润

            即
             if(k <= money) {
                dp[i][j][k] = dp[i-1][j][k]+dp[i-1][j - person][0];
             } else {
                dp[i][j][k] = dp[i-1][j][k]+dp[i-1][j - person][k-money];
             }

             因为 k 代表的是至少的，k - money < 0时是负的，没有这种状态，只能是从 0 开始

             当然题目要求是取余，
             2 % 3 = 2
             4 % 3 = 1
             (2 + 1) % 3 = 0
             即(2 + 4) % 3 = 0

             最多的要求是叠加是因为最大人数 j 是不确定的，即没说人数一定要是 n ,而是从 [0,n]

         */

        int len = group.length;
        int MOD = (int) 1e9 + 7;
        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;

        for (int i = 1; i <= len; i++) {
            int person = group[i - 1];
            int money = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (j < person) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = (dp[i - 1][j][k] +
                                dp[i - 1][j - person][Math.max(0, k - money)])
                                % MOD;
                    }
                }
            }
        }
        int res = 0;
        for (int j = 0; j <= n; j++) {
            res = (res + dp[len][j][minProfit]) % MOD;
        }
        return res;
    }
}
