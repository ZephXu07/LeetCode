package 每日一题;

/**
 * Title: k个逆序对数组629
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-11
 */
public class k个逆序对数组629 {
    public int kInversePairs(int n, int k) {
        int MOD = 1000000007;
        /*
            指在 n为 i % 2时拥有 j 个逆序对的数组个数
         */
        int[][] dp = new int[2][k + 1];
        /*
            初始化，逆序对为0的时候只能为顺序数组，只有1个
         */
        dp[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                int cur = i & 1, prev = cur ^ 1;
                /*
                    dp[i][j] = dp[i][j−1] − dp[i−1][j−i] + dp[i−1][j]
                    这里使用两个一维数组模拟了二维数组
                 */
                dp[cur][j] = (j - 1 >= 0 ? dp[cur][j - 1] : 0) -
                        (j - i >= 0 ? dp[prev][j - i] : 0) + dp[prev][j];

                if (dp[cur][j] >= MOD) {
                    dp[cur][j] -= MOD;
                } else if (dp[cur][j] < 0) {
                    dp[cur][j] += MOD;
                }
            }
        }
        return dp[n & 1][k];
    }
}
