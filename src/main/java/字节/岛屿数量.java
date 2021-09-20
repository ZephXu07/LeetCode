package 字节;

/**
 * Title: 岛屿数量
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-21
 */
public class 岛屿数量 {
    private static final int[][] DIRECTION = {{1,0},{0,1}};

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        UnionFind uF = new UnionFind(row * col);
        int zeroCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    for (int[] d : DIRECTION) {
                        int nx = i + d[0];
                        int ny = j + d[1];
                        if (nx >=0 && nx < row && ny >= 0 && ny < col) {
                            if (grid[nx][ny] == '1') {
                                uF.union(i * col + j, nx * col + ny);
                            }
                        }
                    }
                } else {
                    zeroCount++;
                }
            }
        }
        return uF.count - zeroCount;
    }


        class UnionFind {
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
    }

    public static void main(String[] args) {
        岛屿数量 res = new 岛屿数量();
        char[][] grid = {{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(res.numIslands(grid));
    }
}
