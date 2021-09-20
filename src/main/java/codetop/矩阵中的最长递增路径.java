package codetop;

/**
 * Title: 矩阵中的最长递增路径
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-15
 */
public class 矩阵中的最长递增路径 {
    private static final int[][] DIR = {{-1,0},{1,0},{0,-1},{0,1}};
    private int[][] matrix;
    private int[][] count;
    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        count = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(i, j));
            }
        }
        return res;
    }

    private int dfs (int x, int y) {
        if (count[x][y] != 0) {
            return count[x][y];
        }
        count[x][y] = 1;
        for (int[] d : DIR) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (!isValid(nx, ny)) {
                continue;
            }

            if (matrix[nx][ny] > matrix[x][y]) {
                count[x][y] = Math.max(count[x][y], dfs(nx, ny) + 1);
            }
        }
        return count[x][y];
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < matrix.length
                && y >= 0 && y < matrix[0].length;
    }
}
