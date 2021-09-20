package 每日一题;

import java.util.Arrays;

/**
 * Title: 不同路径
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-09
 */
public class 不同路径 {
    private int count;
    public int uniquePaths(int m, int n) {
        count = 0;
        dfs(0, 0, m, n);
        return count;
    }

    private void dfs(int x, int y, int m, int n) {
        if (x >= m || y >= n) {
            return;
        }
        if (x == m - 1 && y == n - 1) {
            count++;
            return;
        }
        dfs(x + 1, y, m, n);
        dfs(x, y + 1, m, n);
    }


    public static void main(String[] args) {
        不同路径 res = new 不同路径();
        int m = 7;
        int n = 3;
        System.out.println(res.uniquePaths(m, n));
        System.out.println(res.uniquePathsDp(m, n));
    }


    public int uniquePathsDp(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
        /*思路二 优化一：由于dp[i][j] = dp[i-1][j] + dp[i][j-1]，
        因此只需要保留当前行与上一行的数据 (在动态方程中，即pre[j] = dp[i-1][j])，
        两行，空间复杂度O(2n)；
        优化二：cur[j] += cur[j-1], 即cur[j] = cur[j] + cur[j-1]
        等价于思路二-->> cur[j] = pre[j] + cur[j-1]，因此空间复杂度为O(n).
         */

//        int[] pre = new int[n];
//        int[] cur = new int[n];
//        Arrays.fill(pre, 1);
//        Arrays.fill(cur,1);
//        for (int i = 1; i < m;i++){
//            for (int j = 1; j < n; j++){
//                cur[j] = cur[j-1] + pre[j];
//            }
//            pre = cur.clone();
//        }
//        return pre[n-1];


//        int[] cur = new int[n];
//        Arrays.fill(cur,1);
//        for (int i = 1; i < m;i++){
//            for (int j = 1; j < n; j++){
//                cur[j] += cur[j-1] ;
//            }
//        }
//        return cur[n-1];

    }
}
