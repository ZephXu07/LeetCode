package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 出界的路径数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-15
 */
public class 出界的路径数 {
//    private static final int MOD = (int) 1e9 + 7;
//    private static final int[][] DIR = {{-1,0},{1,0},{0,-1},{0,1}};
//    private int m;
//    private int n;
//    private Map<String, Integer> memo;
//    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//        this.m = m;
//        this.n = n;
//        memo = new HashMap<>(m * n);
//        return dfs(startRow, startColumn, maxMove);
//    }
//
//    private int dfs (int x, int y, int step) {
//        if (isOutside(x, y)) {
//            return 1;
//        }
//        if (step == 0) {
//            return 0;
//        }
//        String key = x + "_" + y + "_" + step;
//        if (memo.containsKey(key)) {
//            return memo.get(key);
//        }
//        int res = 0;
//        for (int[] d : DIR) {
//            int nx = x + d[0];
//            int ny = y + d[1];
//
//
//            res = (res + dfs(nx, ny, step - 1)) % MOD;
//
//        }
//        memo.put(key, res);
//        return res;
//    }
//
//    private boolean isOutside (int x, int y) {
//        return x < 0 || x >= m || y < 0 || y >= n;
//    }


    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] DIR = {{-1,0},{1,0},{0,-1},{0,1}};
        int MOD = (int) 1e9 + 7;
        int[][][] dp = new int[m][n][maxMove + 1];
        /*
            在 (i,j) 里最多走 k 步出界的路径数
         */
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= maxMove; k++) {
                dp[0][i][k]++;
                dp[m - 1][i][k]++;
            }

        }
        for (int i = 0; i < m; i++) {
            for (int k = 1; k <= maxMove; k++) {
                dp[i][0][k]++;
                dp[i][n - 1][k]++;
            }
        }
        /*
                计算在边界的点走一步出界的路径数，
                边界有 [0][i],[m-1][i]
                [i][0],[i][n-1]
                所以 [1,maxMove]的初始化都是一样的

                所以在开始 k = 1 时，计算边界会没有影响，因为 k = 0时路径数均为 0
        */
        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] d : DIR) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            continue;
                            /*
                                已经出界的我们不直接计算
                             */
                        }
                        dp[i][j][k] = (dp[i][j][k] + dp[x][y][k - 1]) % MOD;
                        /*
                            计算其四个方向的路径数，相加后取余
                         */
                    }
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
        /*
            返回在题目要求的起点的路径数
         */
    }



    public static void main(String[] args) {
        出界的路径数 res = new 出界的路径数();
//        int m, int n, int maxMove, int startRow, int startColumn
        System.out.println(res.findPaths(2, 2, 2, 0, 0));
        System.out.println(res.findPaths(1, 3, 3, 0, 1));
        System.out.println(res.findPaths(4, 5, 8, 3, 2));
    }
}
