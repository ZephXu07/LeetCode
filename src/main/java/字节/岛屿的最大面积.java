package 字节;

/**
 * Title: 岛屿的最大面积
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-29
 */
public class 岛屿的最大面积 {
    private static final int[][] DIRECTION = {{1,0},{0,1},{-1, 0},{0, -1}};
    private int[][] grid;
    private boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        this.grid = grid;
        visited = new boolean[row][col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    res = Math.max(dfs(i, j), res);
                }
            }
        }
        return res;
    }


    private int dfs (int x, int y) {
        if (!isValid(x, y) || visited[x][y] || grid[x][y] == 0) {
            return 0;
        }
        visited[x][y] = true;
        int sum = 0;
        for (int[] ints : DIRECTION) {
            int nx = x + ints[0];
            int ny = y + ints[1];
            sum += dfs(nx, ny);
        }
        return sum + 1;
    }

    private boolean isValid (int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }

}
