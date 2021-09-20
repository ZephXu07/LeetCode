package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 只有两个键的键盘
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-19
 */
public class 只有两个键的键盘 {
//    private int n;
//    private int res;
//    public int minSteps(int n) {
//        if (n == 1) {
//            /*
//                只需要一个，直接返回
//             */
//            return 0;
//        }
//        this.n = n;
//        res = 1001;
//        /*
//            n 最大范围是 1000 而从 1 到 1000 最多需要 1000 次
//            所以 res 最大 1001
//         */
//        dfs(1, 1, 1, true);
//        /*
//            到此时一定先复制 A 一次，flag 表示上次已经复制了
//         */
//        return res;
//    }
//
//    private void dfs (int count, int sum, int cur, boolean flag) {
//        if (sum == n) {
//            /*
//                刚好则对比
//             */
//            res = Math.min(res, count);
//            return;
//        }
//        if (sum + cur > n || sum > n) {
//            /*
//                现有 和 剪贴板 的和大于 n
//                或者 现有已经大于 n
//                失败了直接返回
//             */
//            return;
//        }
//
//
//        count++;
//        /*
//            复制或者粘贴
//            次数先加一
//         */
//
//        if (flag) {
//            /*
//                上一次是复制了
//                这一次必须是粘贴
//             */
//            dfs(count, sum + cur, cur, false);
//        } else {
//            /*
//                上一次是粘贴了
//                这一次可以是粘贴
//                也可以是重新复制
//             */
//            dfs(count, sum, sum, true);
//            dfs(count, sum + cur, cur, false);
//        }
//
//
//
//    }


    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        /*
            dp[i] 输出 i 个A 的最少操作次数

            自然 dp[1] = 0

            假如当前有 j 个 A，需要输出 i 个A，且 i % j == 0
            此时需要复制 j 个 A 一次，粘贴 j 个 A  (i/j - 1) 次
            即总共需要操作 i / j 次
            即 dp[i] = min(dp[i], dp[j] + i/j)
            同时，设 x = i / j，
            也有 dp[i] = min(dp[i],dp[x] + i/(i/j))
                      = min(dp[i], dp[i/j] + j)
            且 j，x 的最大范围即  sqrt(i)
            int len = sqrt(i) ，则遍历时需要取 =，j,x 最小值为 1
         */
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            int len = (int) Math.sqrt(i);
            for (int j = 1; j <= len; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i],
                            Math.min(dp[j] + i / j, dp[i / j] + j));
                }
            }
        }
        return dp[n];

    }


    public static void main(String[] args) {
        只有两个键的键盘 res = new 只有两个键的键盘();
        System.out.println(res.minSteps(3) + "\t3");
        System.out.println(res.minSteps(1) + "\t1");
    }
}
