package 剑指offer专项突击版;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 矩阵中的距离107
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-04
 */
public class 矩阵中的距离107 {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] dire = {{-1,0},{1,0},{0,-1},{0,1}};

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] res = new int[row][col];
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int i = tmp[0];
            int j = tmp[1];
            for (int[] d : dire) {
                int x = i + d[0];
                int y = j + d[1];
                if (x >= 0 && x < row && y >= 0 && y < col && mat[x][y] == 1) {
                    res[x][y] = res[i][j] + 1;
                    queue.offer(new int[]{x, y});
                    mat[x][y] = 0;
                }

            }
        }
        return res;
    }


}
