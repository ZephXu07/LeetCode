package 每日一题;

/**
 * Title: 省份数量
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-07
 */
public class 省份数量 {
    public int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        UnionFind unionFind = new UnionFind(row);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            if (unionFind.find(i) == i) {
                count++;
            }
        }
        return count;
    }
}
class UnionFind {
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