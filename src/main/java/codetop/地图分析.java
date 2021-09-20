package codetop;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 地图分析
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-15
 */
public class 地图分析 {
//    private int[][] grid;
//    private int row;
//    private int col;
//    private static final int[] DIR = {-1,0,1,0,-1};
//    public int maxDistance(int[][] grid) {
//        this.grid = grid;
//        row = grid.length;
//        col = grid[0].length;
//        int res = -1;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (grid[i][j] == 0) {
//                    res = Math.max(res, bfs(i, j));
//                }
//            }
//        }
//        return -1;
//
//    }
//
//    private int bfs (int x, int y) {
//        boolean[][] visited = new boolean[row][col];
//        visited[x][y] = true;
//        Queue<int[]> queue = new LinkedList<>();
//        queue.offer(new int[]{x, y, 0});
//        while (!queue.isEmpty()) {
//            int[] tmp = queue.poll();
//            for (int i = 0; i < 4; i++) {
//                int nx = tmp[0] + DIR[i];
//                int ny = tmp[1] + DIR[i + 1];
//                if (!isValid(nx, ny) || visited[nx][ny]) {
//                    continue;
//                }
//                queue.offer(new int[]{nx, ny, tmp[2] + 1});
//                visited[nx][ny] = true;
//                if (grid[nx][ny] == 1) {
//                    return tmp[2] + 1;
//                }
//            }
//        }
//        return -1;
//    }
//
//    private boolean isValid (int x, int y) {
//        return x >= 0 && x < row && y >= 0 && y < col;
//    }

    private int[][] grid;
    private int row;
    private int col;
    private static final int[] DIR = {-1,0,1,0,-1};

    public int maxDistance(int[][] grid) {
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = -1;
                }
            }
        }

        int res = -1;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int step = Math.max(grid[x][y], 0);
            for (int i = 0; i < 4; i++) {
                int nx = x + DIR[i];
                int ny = y + DIR[i + 1];

                if (!isValid(nx, ny) || grid[nx][ny] != 0) {
                    continue;
                }

                grid[nx][ny] = step + 1;
                res = Math.max(grid[nx][ny], res);
                queue.offer(new int[]{nx, ny});

            }
        }
        return res;
    }

    private boolean isValid (int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

}
