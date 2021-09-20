package 字节;

/**
 * Title: 生成数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-22
 */
public class 生成数组 {
    

    public int numOfArrays(int n, int m, int k) {
        // 不存在搜索代价为 0 的数组
        if (k == 0) {
            return 0;
        }

        int[][][] dp = new int[51][51][101];
        int mod = 1000000007;
        
        // 边界条件，所有长度为 1 的数组的搜索代价都为 1
        for (int j = 1; j <= m; j++) {
            dp[1][1][j] = 1;
        }
        for (int i = 2; i <= n; ++i) {
            // 搜索代价不会超过数组长度
            for (int s = 1; s <= k && s <= i; ++s) {
//                for (int j = 1; j <= m; ++j) {
//                    dp[i][s][j] = (int) ((long) dp[i - 1][s][j] * j % mod);
//                    for (int j0 = 1; j0 < j; ++j0) {
//                        dp[i][s][j] += dp[i - 1][s - 1][j0];
//                        dp[i][s][j] %= mod;
//                    }
//                }
                int pre = 0;
                for (int j = 1; j <= m; ++j) {
                    dp[i][s][j] = (int) ((long)dp[i - 1][s][j] * j % mod);
                    dp[i][s][j] = (dp[i][s][j] + pre) % mod;
                    pre = (pre + dp[i - 1][s - 1][j]) % mod;
                }
            }
        }

        // 最终的答案是所有 dp[n][k][..] 的和
        // 即数组长度为 n，搜索代价为 k，最大值任意
        int res = 0;
        for (int j = 1; j <= m; ++j) {
            res += dp[n][k][j];
            res %= mod;
        }
        return res;
    }
    
}

