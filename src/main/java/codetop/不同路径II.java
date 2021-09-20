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

        if (obstacleGrid[row - 1][col - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[2][col];
        dp[(row - 1) & 1][col - 1] = 1;

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (i + 1 < row) {
                    dp[i & 1][j] += dp[(i + 1) & 1][j];
                }
                if (j + 1 < col) {
                    dp[i & 1][j] += dp[i & 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}
