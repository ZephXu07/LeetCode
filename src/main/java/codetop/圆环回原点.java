package codetop;

import 字节.原子的数量;

/**
 * Title: 圆环回原点
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-08
 */
public class 圆环回原点 {

    public int backToOrigin (int n) {
        int len = 10;
        /*
            多少个点，[0,9]
         */
        int[][] dp = new int[n + 1][len];
        /*
            从 0 开始，走 i [0, n] 步到点 j [0,9] 的方案数
         */
        dp[0][0] = 1;
        /*
            从 0 开始，不走，即在原地的方案只有 1 种
         */

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + len) % len]
                        + dp[i - 1][(j + 1) % len];
                /*
                    走 i 步到 j 的方案当然等于走 i - 1 步到 j + 1 或者 j - 1 的方案数
                    (j - 1 + len) % len 负数的话因为环会从末尾开始，整数则不影响
                    (j + 1) % len 超过圆环点数从 0 开始计算
                 */
            }
        }

        return dp[n][0];
        /*
            返回题目要求的从 0 开始走 n 步到 0
         */
    }

    public int backToOrigin1 (int n) {
        /*
            空间优化
         */
        int len = 10;
        /*
            多少个点，[0,9]
         */
        int[][] dp = new int[2][len];
        /*
            从 0 开始，走 i [0, n] 步到点 j [0,9] 的方案数
         */
        dp[0][0] = 1;
        /*
            从 0 开始，不走，即在原地的方案只有 1 种
         */

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < len; j++) {
                int inx = (i - 1) & 1;
                dp[i & 1][j] = dp[inx][(j - 1 + len) % len]
                        + dp[inx][(j + 1) % len];
                /*
                    走 i 步到 j 的方案当然等于走 i - 1 步到 j + 1 或者 j - 1 的方案数
                    (j - 1 + len) % len 负数的话因为环会从末尾开始，整数则不影响
                    (j + 1) % len 超过圆环点数从 0 开始计算
                 */
            }
        }

        return dp[n & 1][0];
        /*
            返回题目要求的从 0 开始走 n 步到 0
         */
    }

    public static void main(String[] args) {
        圆环回原点 res = new 圆环回原点();
        System.out.println(res.backToOrigin(2));
        System.out.println(res.backToOrigin1(2));
    }
}
