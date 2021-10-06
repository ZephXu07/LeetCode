package 杂类;

/**
 * Title: 二进制矩阵中的最短路径1091
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-07
 */
public class 二进制矩阵中的最短路径1091 {
    private int res;
    private static final int[][] DIRECTION = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        res = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        if (dfs(grid, visited, 0, 0, 0)) {
            return res + 1;
        }
        return -1;
    }

    private boolean dfs (int[][] grid, boolean[][] visited, int x, int y, int count) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            res = Math.min(res, count);
            return true;
        }

        for (int[] d : DIRECTION) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length
                    && !visited[nx][ny] && grid[nx][ny] == 0) {
                visited[nx][ny] = true;
                if (dfs(grid, visited, nx, ny, count + 1)) {
                    return true;
                }
                visited[nx][ny] = false;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        二进制矩阵中的最短路径1091 res = new 二进制矩阵中的最短路径1091();
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(res.shortestPathBinaryMatrix(grid));
    }


}
