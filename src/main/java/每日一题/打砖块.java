package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 打砖块
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-16
 */
public class 打砖块 {
    public static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int row;
    private int col;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        row = grid.length;
        col = grid[0].length;

        int[][] copy = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        int x = 0;
        int y = 0;
        for (int[] hit : hits) {
            x = hit[0];
            y = hit[1];
            copy[x][y] = 0;
        }
        int size = row * col;
        UnionFind uF = new UnionFind(size + 1);
        for (int i = 0; i < col; i++) {
            if (copy[0][i] == 1) {
                uF.union(i, size);
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (copy[i][j] == 1) {
                    // 如果上方也是砖块
                    if (copy[i - 1][j] == 1) {
                        uF.union(simplifyInx(i - 1, j), simplifyInx(i, j));
                    }
                    // 如果左边也是砖块
                    if (j > 0 && copy[i][j - 1] == 1) {
                        uF.union(simplifyInx(i, j - 1), simplifyInx(i, j));
                    }
                }
            }
        }

        // 第 3 步：按照 hits 的逆序，在 copy 中补回砖块，把每一次因为补回砖块而与屋顶相连的砖块的增量记录到 res 数组中
        int hitsLen = hits.length;
        int[] res = new int[hitsLen];
        for (int i = hitsLen - 1; i >= 0; i--) {
            x = hits[i][0];
            y = hits[i][1];

            // 注意：这里不能用 copy，语义上表示，如果原来在 grid 中，这一块是空白，这一步不会产生任何砖块掉落
            // 逆向补回的时候，与屋顶相连的砖块数量也肯定不会增加
            if (grid[x][y] == 0) {
                continue;
            }

            // 补回之前与屋顶相连的砖块数
            int ori = uF.getSize(size);

            // 注意：如果补回的这个结点在第 1 行，要告诉并查集它与屋顶相连（逻辑同第 2 步）
            if (x == 0) {
                uF.union(y, size);
            }

            // 在 4 个方向上看一下，如果相邻的 4 个方向有砖块，合并它们
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                if (inArea(newX, newY) && copy[newX][newY] == 1) {
                    uF.union(simplifyInx(x, y), simplifyInx(newX, newY));
                }
            }

            // 补回之后与屋顶相连的砖块数
            int cur = uF.getSize(size);
            // 减去的 1 是逆向补回的砖块（正向移除的砖块），与 0 比较大小，是因为存在一种情况，添加当前砖块，不会使得与屋顶连接的砖块数更多
            res[i] = Math.max(0, cur - ori - 1);

            // 真正补上这个砖块
            copy[x][y] = 1;
        }

        return res;




    }

    private int simplifyInx(int x, int y) {
        return x * col + y;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }


    private class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int len) {
            parent = new int[len];
            size = new int[len];
            for (int i = 0; i < len; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        
        private int getSize(int index) {
            return size[find(index)];
        }
    }

}