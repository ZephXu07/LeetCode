package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 相似字符串组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-31
 */
public class 相似字符串组 {
    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        UnionFind uF = new UnionFind(len);
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    uF.union(i, j);
                }
            }
        }
        return uF.count;
    }

    private boolean isSimilar(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                count++;
            }
            if (count > 2) {
                return false;
            }
        }
        return true;
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
