package codetop;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 腐烂的橘子
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-15
 */
public class 腐烂的橘子 {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] dir = {-1, 0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                    grid[i][j] = 0;
                }
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = queue.poll();
                int x = tmp[0];
                int y = tmp[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dir[j];
                    int ny = y + dir[j + 1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 1) {
                        grid[nx][ny] = 0;
                        queue.offer(new int[]{nx, ny, tmp[2] + 1});
                        /*
                            [2] 存放遍历到此位置的时间
                         */
                        res = tmp[2] + 1;
                        /*
                            记录最后遍历的时间
                         */
                    }

                }
            }
        }
        for (int[] ints : grid) {
            for (int j = 0; j < col; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        腐烂的橘子 res = new 腐烂的橘子();
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(res.orangesRotting(grid));
    }
}
