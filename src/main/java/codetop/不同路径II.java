package codetop;

/**
 * Title: 不同路径II
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-20
 */
public class 不同路径II {
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int row = obstacleGrid.length;
//        int col = obstacleGrid[0].length;
//
//        if (obstacleGrid[row - 1][col - 1] == 1) {
//            return 0;
//        }
//        int[][] dp = new int[row][col];
//        dp[row - 1][col - 1] = 0;
//
//        for (int i = row - 1; i >= 0; i--) {
//            for (int j = col - 1; j >= 0; j--) {
//                if (obstacleGrid[i][j] == 1) {
//                    continue;
//                }
//                if (i + 1 < row) {
//                    dp[i][j] += dp[i + 1][j];
//                }
//                if (j + 1 < col) {
//                    dp[i][j] += dp[i][j + 1];
//                }
//            }
//        }
//        return dp[0][0];
//    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] dp = new int[col];
        //起点可能有障碍物
        dp[0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                //有障碍物的格子直接赋0
                if(obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                }
                //否则dp[j]的值由左方和上一次迭代的dp[j]累加而来
                else if(obstacleGrid[i][j] == 0 && j - 1 >= 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[col - 1];

    }

}
