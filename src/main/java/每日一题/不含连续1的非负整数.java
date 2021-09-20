package 每日一题;

/**
 * Title: 不含连续1的非负整数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-11
 */
public class 不含连续1的非负整数 {
//    private int res;
//    public int findIntegers(int n) {
//        res = 1;
//        dfs(1, n);
//        return res;
//    }
//
//    private void dfs (int cur, int n) {
//        if (cur > n) {
//            return;
//        }
//        res++;
//        if ((cur & 1) == 1) {
//            dfs(cur << 1, n);
//        } else {
//            dfs(cur << 1, n);
//            dfs((cur << 1) + 1, n);
//        }
//    }


//    public int findIntegers(int n) {
//        // 预处理第 i 层满二叉树的路径数量
//        int[] dp = new int[31];
//        dp[0] = dp[1] = 1;
//        for (int i = 2; i < 31; ++i) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//
//        // pre 记录上一层的根节点值，res 记录最终路径数
//        int pre = 0, res = 0;
//        for (int i = 29; i >= 0; --i) {
//            int val = 1 << i;
//            // if 语句判断 当前子树是否有右子树
//            if ((n & val) != 0) {
//                // 有右子树
//                n -= val;
//                res += dp[i + 1]; // 先将左子树（满二叉树）的路径加到结果中
//
//                // 处理右子树
//                if (pre == 1) {
//                    // 上一层为 1，之后要处理的右子树根节点肯定也为 1
//                    // 此时连续两个 1，不满足题意，直接退出
//                    break;
//                }
//                // 标记当前根节点为 1
//                pre = 1;
//            } else {
//                // 无右子树，此时不能保证左子树是否为满二叉树，所以要在下一层再继续判断
//                pre = 0;
//            }
//
//            if (i == 0) {
//                ++res;
//            }
//        }
//
//        return res;
//    }

    public int findIntegers(int n) {
        /*
            预处理32位整数
            dp[i]表示长度为i时有多少个不包含连续1的数
            dp[i] = dp[i - 1] + dp[i - 2]

            四个位 ____
            假如 0___  ___ 有多少种不包含连续1的数，即 dp[3]
            假如 1___  即有 10__ __ 有多少种不包含连续1的数，即 dp[2]

            而长度为0的数只有一种，长度为1有两种，0, 1
            所以 dp[0] = 1 dp[1] = 2
         */
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int res = 0;
        int pre = 0;
        for (int i = 31; i >= 0; i--) {
            /*
                找到每一个1，看它的下一位的方案数
                注意：这里的i是从0开始的，它正好等于（位数-1）
                所以，下一位正好对应到i下标
             */
            if (((n >> i) & 1) == 1) {
                res += dp[i];
                if (pre == 1) {
                    /*
                        连续 1
                     */
                    return res;
                }
                pre = 1;
            } else {
                pre = 0;
            }
        }

        // 当前数也是符合条件的，如果不符合在上面的return已经返回了
        return res + 1;
    }
}
