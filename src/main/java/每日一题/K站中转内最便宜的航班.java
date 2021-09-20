package 每日一题;

import java.util.Arrays;

/**
 * Title: K站中转内最便宜的航班
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-24
 */
public class K站中转内最便宜的航班 {
//    private static final int INF = 1000001;
//    /*
//        题目的最大范围是 10^6
//     */
//    private int[][] flights;
//    private int dst;
//    private int[][] memo;
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        this.flights = flights;
//        this.dst = dst;
//        memo = new int[n][k + 2];
//        /*
//            memo[src][k]
//            src 到 dst 最多走 k 步的最小价格
//            k 从 1 开始，题目是经过的点数为k
//            而经过 k 点是走了 k + 1 条边
//            所以综上 k + 2 的数组
//         */
//        int res = dfs(src, k + 1);
//        return res >= INF ? -1 : res;
//    }
//
//    private int dfs (int src, int k) {
//        if (k < 0) {
//            return INF;
//            /*
//                剩下的步数 k 为负数
//                表示已经不能再走了
//                此时还没有到达 dst，
//                于是返回最大价格
//                表示到达不了 dst
//             */
//        }
//
//        if (src == dst) {
//            /*
//                到达 dst 了
//                表示不用再走了
//                价格为 0
//             */
//            return 0;
//        }
//
//        if (memo[src][k] != 0) {
//            return memo[src][k];
//            /*
//                从 src 到 dst 最多走 k 步已经计算了
//                直接返回
//             */
//        }
//
//        int res = INF;
//        /*
//            预设最大，再进行比较
//         */
//        for (int[] f : flights) {
//            if (f[0] == src) {
//                /*
//                    如果这条航线出发点是 src
//                 */
//                res = Math.min(res, dfs(f[1], k - 1) + f[2]);
//                /*
//                    计算此航线结束点到 dst 走 k - 1 步的最小价格
//                    再计算此航线的价格
//
//                    可能有多条航线，进行搜索与比较
//                 */
//            }
//        }
//
//        memo[src][k] = res;
//        /*
//            存储
//         */
//
//        return res;
//    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        /*
            dp[src][k]
            src 到 dst 最多走 k 步的最小价格
            k 从 1 开始，题目是经过的点数为k
            而经过 k 点是走了 k + 1 条边
            所以综上 k + 2 的数组

            dp[dst][0] = 0
            终点最多走 0 步到达目的地的价格为 0 ，其他初始化为题目最大值
            某个点最多走 k 步的到达目的地的最小价格 =
            这个点的所有航线终点走 k - 1 步到达目的地的最小价格加上航线本身的价格

         */
        int inf = 1000001;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], inf);
        }

        dp[dst][0] = 0;

        for (int i = 1; i < k + 2; i++) {
            for (int[] f : flights) {
                dp[f[0]][i & 1] = Math.min(dp[f[0]][i & 1], dp[f[1]][(i - 1) & 1] + f[2]);
            }
        }

        int res = inf;
        for (int d : dp[src]) {
            res = Math.min(res, d);
        }

        return res >= inf ? -1 : res;

    }

}
