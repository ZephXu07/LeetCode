package codetop;

/**
 * Title: 不同的二叉搜索树
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-29
 */
public class 不同的二叉搜索树 {
    public int numTrees(int n) {
        /*
            G(n) ：n 个节点存在二叉排序树的个数
            f(i) ：以 i 为 根的二叉排序树的个数
            G(n) = f(1) + f(2) + ... + f(n)

            当 i 为根时，左子树节点为 [1, i) 即 i - 1 个
                        右子树节点为 [i + 1, n] 即 n - i 个
            即有
            f(i) = G(i - 1) * G(n - i)

            G(n) = G(0) * G(n - 1) + G(1) * G(n - 2) + ... + G(n - 1) * G(0)


         */
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
                /*
                    当 i = 2, j = 1
                    G(2) = G(0) * G(1) + G(1) * G(0)

                        G(j-1)*G(i-j)
                 */
            }
        }

        return dp[n];
    }
}
