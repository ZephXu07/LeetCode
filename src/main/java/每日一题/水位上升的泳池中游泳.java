package 每日一题;

/**
 * Title: 水位上升的泳池中游泳
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-30
 */
public class 水位上升的泳池中游泳 {
    private static final int[][] DIRECTION = {{-1,0},{1,0},{0, -1},{0,1}};

    private int len;

    public int swimInWater(int[][] grid) {
        len = grid.length;
        int sum = len * len;
        int[] heiToInx = new int[sum];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                heiToInx[grid[i][j]] = getInx(i, j);
            }
        }
        UnionFind uF = new UnionFind(sum);
        int x;
        int y;
        int nx;
        int ny;
        for (int i = 0; i < sum; i++) {
            x = heiToInx[i] / len;
            y = heiToInx[i] % len;
            for (int[] d : DIRECTION) {
                nx = x + d[0];
                ny = y + d[1];

                if (inArea(nx, ny) && grid[nx][ny] <= i) {
                    uF.union(heiToInx[i], getInx(nx, ny));
                }

                if (uF.isConnectd(0, sum - 1)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int getInx(int i, int j) {
        return i * len + j;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < len && y >=0 && y < len;
    }

    private class UnionFind {
        private int[] parent;
        private int[] size;
        private int count;
        public UnionFind(int len) {
            parent = new int[len];
            size = new int[len];
            count = len;
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
            count--;
        }

        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean isConnectd(int p, int q) {
            return find(p) == find(q);
        }
    }
}
