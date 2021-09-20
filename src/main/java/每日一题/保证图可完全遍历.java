package 每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: 保证图可完全遍历
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-27
 */
public class 保证图可完全遍历 {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int len = edges.length;
        UnionFind alice = new UnionFind(n + 1);
        UnionFind bob = new UnionFind(n + 1);
        int count = 0;
        for (int[] edge : edges) {
            int u = edge[1];
            int v = edge[2];
            if (edge[0] == 3) {
                if (!alice.union(u, v)) {
                    count++;
                }
                bob.union(u, v);
            }
        }
        for (int[] edge : edges) {
            int u = edge[1];
            int v = edge[2];
            if (edge[0] == 1) {
                if (!alice.union(u, v)) {
                    count++;
                }
            } else if (edge[0] == 2) {
                if (!bob.union(u, v)) {
                    count++;
                }
            }
        }
        if (alice.count != 2 || bob.count != 2) {
            return -1;
        }
        return count;
    }

    public static void main(String[] args) {
        保证图可完全遍历 res = new 保证图可完全遍历();
        int n = 13;
//        int[][] edges = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
//        int[][] edges = {{3,1,2},{3,2,3},{1,1,4},{2,1,4}};
//        int[][] edges = {{3,1,2},{1,1,2},{2,3,4}};
        int[][] edges = {{1,1,2},{2,1,3},{3,2,4},{3,2,5},
        {1,2,6},{3,6,7},{3,7,8},{3,6,9},{3,4,10},
        {2,3,11},{1,5,12},{3,3,13},{2,1,10},{2,6,11},
        {3,5,13},{1,9,12},{1,6,8},{3,6,13},{2,1,4},{1,1,13},
        {2,9,10},{2,1,6},{2,10,13},{2,2,9},{3,4,12},{2,4,7},{1,1,10},
        {1,3,7},{1,7,11},{3,3,12},{2,4,8},{3,8,9},{1,9,13},{2,4,10},
        {1,6,9},{3,10,13},{1,7,10},{1,1,11},{2,4,9},{3,5,11},{3,2,6},
        {2,1,5},{2,5,11},{2,1,7},{2,3,8},{2,8,9},{3,4,13},{3,3,8},{3,3,11},
        {2,9,11},{3,1,8},{2,1,8},{3,8,13},{2,10,11},{3,1,5},{1,10,11},
        {1,7,12},{2,3,5},{3,1,13},{2,4,11},{2,3,9},{2,6,9},{2,1,13},{3,1,12},
        {2,7,8},{2,5,6},{3,1,9},{1,5,10},{3,2,13},{2,3,6},{2,2,10},{3,4,11},
        {1,4,13},{3,5,10},{1,4,10},{1,1,8},{3,3,4},{2,4,6},{2,7,11},{2,7,10},
        {2,3,12},{3,7,11},{3,9,10},{2,11,13},{1,1,12},{2,10,12},{1,7,13},
        {1,4,11},{2,4,5},{1,3,10},{2,12,13},{3,3,10},{1,6,12},{3,6,10},{1,3,4},
        {2,7,9},{1,3,11},{2,2,8},{1,2,8},{1,11,13},{1,2,13},{2,2,6},{1,4,6},
        {1,6,11},{3,1,2},{1,1,3},{2,11,12},{3,2,11},{1,9,10},{2,6,12},{3,1,7},
        {1,4,9},{1,10,12},{2,6,13},{2,2,12},{2,1,11},{2,5,9},{1,3,8},{1,7,8},
        {1,2,12},{1,5,11},{2,7,12},{3,1,11},{3,9,12},{3,2,9},{3,10,11}};
        System.out.println(res.maxNumEdgesToRemove(n, edges));
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
