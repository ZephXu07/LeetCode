package 杂类;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Title: 二进制矩阵中的最短路径1091
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-07
 */
public class 二进制矩阵中的最短路径1091 {

    private static final int[][] DIRECTION = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        set1.add(0);
        set2.add((row - 1) * 10000 + col - 1);
        int step = 1;
        while (!set1.isEmpty()) {
            Set<Integer> tmp = new HashSet<>();

            for (Integer xy : set1) {
                if (visited.contains(xy)) {
                    continue;
                }
                if (set2.contains(xy)) {
                    return step;
                }
                visited.add(xy);
                int x = xy / 10000;
                int y = xy % 10000;
                for (int[] d : DIRECTION) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col
                            && grid[nx][ny] == 0) {
                        if (visited.contains(nx * 10000 + ny)) {
                            continue;
                        }
                        tmp.add(nx * 10000 + ny);
                    }
                }
            }
            step++;
            if (set2.size() <= tmp.size()) {
                set1 = set2;
                set2 = tmp;
            } else {
                set1 = tmp;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        二进制矩阵中的最短路径1091 res = new 二进制矩阵中的最短路径1091();
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
//        int[][] grid = {{0,1},{1,0}};
        System.out.println(res.shortestPathBinaryMatrix(grid));
    }


}
