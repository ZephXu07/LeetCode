package 剑指offer专项突击版;

/**
 * Title: 岛屿数量200
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-05
 */
public class 岛屿数量200 {
    private int[][] DIRECTION = {{-1,0},{1,0},{0,-1},{0,1}};

    public int numIslands(char[][] grid) {
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return res;
    }

    private void dfs (char[][] grid, int x, int y, int row, int col) {
        grid[x][y] = '0';
        for (int[] d : DIRECTION) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == '1') {
                dfs(grid, nx, ny, row, col);
            }
        }
    }


}
