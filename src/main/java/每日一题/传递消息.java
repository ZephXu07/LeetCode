package 每日一题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 传递消息
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-01
 */
public class 传递消息 {
//    private boolean[][] edge;
//    private int res;
//    private int target;
//    public int numWays(int n, int[][] relation, int k) {
//        edge = new boolean[n][n];
//        for (int[] r : relation) {
//            edge[r[0]][r[1]] = true;
//        }
//        res = 0;
//        target = n - 1;
//        dfs(0, k);
//        return res;
//    }
//
//    private void dfs (int y, int k) {
//        if (k == 0) {
//            if (y == target) {
//                res++;
//            }
//            return;
//        }
//        for (int i = 0; i < edge[y].length; i++) {
//            if (edge[y][i]) {
//                dfs(i, k - 1);
//            }
//        }
//    }

    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        /*
            经过 i 步到达 j 的总方案数
            初始化，dp[0][0] = 1
            因为经过 0 步到达 0 的方案数只有一个

            又 relation[][]  数组是从 x 到 y 的 xy[]的集合,
            即知道了到达 x 的方案数，就知道了到 y 的方案数还能有哪些
            所以 dp 方程可以从其中求出
            dp[i + 1][y] = dp[i + 1][y] + dp[i][x]

            dp[i + 1][y]：最新的 i + 1步到达 y 的方案数
            dp[i + 1][y]：本来已知道的 i + 1步到达 y 的方案数
            dp[i][x]：已知道的 i 步到达 x 的方案数

         */
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] xy : relation) {
                int x = xy[0];
                int y = xy[1];
                dp[i + 1][y] += dp[i][x];
            }
        }
        return dp[k][n - 1];
    }
}
