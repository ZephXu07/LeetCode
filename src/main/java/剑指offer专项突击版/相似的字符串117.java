package 剑指offer专项突击版;

/**
 * Title: 相似的字符串117
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-08
 */
public class 相似的字符串117 {
    public int numSimilarGroups(String[] strs) {
        UnionFind uF = new UnionFind(strs.length);
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    uF.union(i, j);
                }
            }
        }
        return uF.count;
    }

    private boolean isSimilar (String s, String t) {
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
