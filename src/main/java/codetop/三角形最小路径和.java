package codetop;

import java.util.List;

/**
 * Title: 三角形最小路径和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-07
 */
public class 三角形最小路径和 {
    public int minimumTotal0(List<List<Integer>> triangle) {
        /*
                [2]
                [3,4]
                [6,5,7]
                [4,1,8,3]

                dp[i][j] 到达 i 层， j 列的最小路径和 i-->[0,len) j-->[0,i]

                因为只能从上一层的同一列或者左边一列移动，所以有
                dp[i][j] = min(dp[i - 1][j],dp[i - 1][j - 1]) + val

                同时处在最左侧，只能由上一层最左侧转移，所以有
                dp[i][0] = dp[i-1][0]+val

                同时处在最右侧，只能由上一层最右侧转移，因为一层比一层多一列，所以有
                dp[i][i] = dp[i - 1][i - 1]+val

                而最开始是 0 层 0 列，即 dp[0][0] = val
         */
        int len = triangle.size();
        int[][] dp = new int[len][len];

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < len; i++) {

            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }

            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        int res = Integer.MAX_VALUE;
        for (int i : dp[len - 1]) {
            res = Math.min(res, i);
        }

        return res;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        /*
                [2]
                [3,4]
                [6,5,7]
                [4,1,8,3]

                dp[i][j] 到达 i 层， j 列的最小路径和 i-->[0,len) j-->[0,i]

                因为只能从上一层的同一列或者左边一列移动，所以有
                dp[i][j] = min(dp[i - 1][j],dp[i - 1][j - 1]) + val

                同时处在最左侧，只能由上一层最左侧转移，所以有
                dp[i][0] = dp[i-1][0]+val

                同时处在最右侧，只能由上一层最右侧转移，因为一层比一层多一列，所以有
                dp[i][i] = dp[i - 1][i - 1]+val

                而最开始是 0 层 0 列，即 dp[0][0] = val
         */
        int len = triangle.size();
        int[][] dp = new int[2][len];

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < len; i++) {

            dp[i & 1][0] = dp[(i - 1) & 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i & 1][j] = Math.min(dp[(i - 1) & 1][j - 1], dp[(i - 1) & 1][j]) + triangle.get(i).get(j);
            }

            dp[i & 1][i] = dp[(i - 1) & 1][i - 1] + triangle.get(i).get(i);
        }

        int res = Integer.MAX_VALUE;
        for (int i : dp[(len - 1) & 1]) {
            res = Math.min(res, i);
        }

        return res;
    }
}
