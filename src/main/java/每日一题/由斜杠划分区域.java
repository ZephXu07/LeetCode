package 每日一题;

/**
 * Title: 由斜杠划分区域
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-25
 */
public class 由斜杠划分区域 {
    public int regionsBySlashes(String[] grid) {
        int len = grid.length;
        UnionFind uF = new UnionFind(4 * len * len);
        for (int i = 0; i < len; i++) {
            char[] chars = grid[i].toCharArray();
            for (int j = 0; j < len; j++) {
                int inx = 4 * (i * len + j);
                if (' ' == chars[j]) {
                    uF.union(inx, inx + 1);
                    uF.union(inx, inx + 2);
                    uF.union(inx, inx + 3);
                } else if ('/' == chars[j]) {
                    uF.union(inx, inx + 3);
                    uF.union(inx + 1, inx + 2);
                } else {
                    uF.union(inx, inx + 1);
                    uF.union(inx + 2, inx + 3);
                }

                if (i + 1 < len) {
                    uF.union(inx + 2, 4 * ((i + 1) * len + j));
                }

                if (j + 1 < len) {
                    uF.union(inx + 1, 4 * (i * len + j + 1) + 3);
                }
            }
        }
        return uF.count;
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
    }
}
