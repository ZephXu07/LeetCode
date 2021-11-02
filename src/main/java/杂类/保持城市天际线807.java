package 杂类;

/**
 * Title: 保持城市天际线807
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-02
 */
public class 保持城市天际线807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int len = grid.length;
        int[] row = new int[len];
        int[] col = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                res += Math.min(row[i], col[j]) - grid[i][j];
            }
        }

        return res;
    }
}
