package 剑指offer;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 礼物的最大价值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-05
 */
public class 礼物的最大价值 {
    private List<Integer> res;
    public int maxValueDfs(int[][] grid) {
        res = new LinkedList<>();
        dfs(grid, 0, 0, 0);
        int max = Integer.MIN_VALUE;
        for (int i : res) {
            max = Math.max(i, max);
        }
        return max;
    }

    private void dfs(int[][] grid, int x, int y, int sum) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            res.add(sum);
            return;
        }
        sum += grid[x][y];
        dfs(grid, x + 1, y, sum);
        dfs(grid, x, y + 1, sum);
    }


    public int maxValueDp(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < column; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][column - 1];
    }

    public int maxValueDpOptimized(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 1; i < column; i++) {
            grid[0][i] = grid[0][i] + grid[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[row - 1][column - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},
                        {1,5,1},
                        {4,2,1}};
        礼物的最大价值 res = new 礼物的最大价值();
        System.out.println(res.maxValueDfs(grid));
        System.out.println(res.maxValueDp(grid));
    }
}
