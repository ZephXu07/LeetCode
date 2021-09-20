package 每日一题;

import java.util.Arrays;

/**
 * Title: 冗余连接
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-18
 */
public class 冗余连接 {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        UnionFind uF = new UnionFind(len);
        int p;
        int q;
        for (int i = 0; i < len; i++) {
            p = edges[i][0];
            q = edges[i][1];
            if (uF.find(p) == uF.find(q)) {
                return edges[i];
            } else {
                uF.union(p, q);
            }
        }
        return new int[0];
    }

    private class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int len) {
            parent = new int[len + 1];
            size = new int[len + 1];
            for (int i = 0; i < len + 1; i++) {
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

        public boolean isConnected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
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
        冗余连接 res = new 冗余连接();
        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        System.out.println(Arrays.toString(res.findRedundantConnection(edges)));
    }
}
