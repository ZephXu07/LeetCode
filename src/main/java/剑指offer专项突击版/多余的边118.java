package 剑指offer专项突击版;

/**
 * Title: 多余的边118
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-08
 */
public class 多余的边118 {
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        UnionFind uF = new UnionFind(len + 1);
        for (int[] e : edges) {
            if (uF.find(e[0]) == uF.find(e[1])) {
                return e;
            } else {
                uF.union(e[0], e[1]);
            }
        }
        return new int[0];
    }

    class UnionFind {
        private int[] parent;
        private int[] size;
        private int count;
        public UnionFind (int len) {
            parent = new int[len];
            size = new int[len];
            count = len;
            for (int i = 0; i < len; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        private int find (int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union (int p, int q) {
            int parP = find(p);
            int parQ = find(q);
            if (parP == parQ) {
                return;
            }
            if (size[parP] <= size[parQ]) {
                parent[parP] = parQ;
                size[parQ] += size[parP];
            } else {
                parent[parQ] = parP;
                size[parP] += size[parQ];
            }
            count--;
        }
    }
}
