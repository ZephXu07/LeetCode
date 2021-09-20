package 每日一题;

/**
 * Title: 连通网络的操作次数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-23
 */
public class 连通网络的操作次数 {

    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        UnionFind uF = new UnionFind(n);
        int count = 0;
        for (int[] edge : connections) {
            if (uF.union(edge[0], edge[1])) {
                continue;
            }
            count++;
        }
        int remain = 0;
        for (int i = 0; i < n; i++) {
            if (uF.find(i) == i) {
                remain ++;
            }
        }
        remain --;
        if (count >= remain) {
            return remain;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        连通网络的操作次数 network = new 连通网络的操作次数();
        int n = 6;
        int[][] connections = {{0,1},{0,2},{0,3},{1,2}};
        System.out.println(network.makeConnected(n, connections));
    }

    private static class UnionFind {
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

        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return false;
            }
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
            return true;
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
