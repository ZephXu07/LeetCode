package 每日一题;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Title: 交换字符中的元素
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-18
 */
public class 交换字符中的元素 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (null == pairs || pairs.size() == 0) {
            return s;
        }
        int len = s.length();
        UnionFind uF = new UnionFind(len);
        int p;
        int q;
        for (List<Integer> list : pairs) {
            p = list.get(0);
            q = list.get(1);
            uF.union(p, q);
        }
        char[] chars = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int root = uF.find(i);
            map.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(chars[i]);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = uF.find(i);
            builder.append(map.get(root).poll());
        }
        return builder.toString();
    }

    private class UnionFind {
        // 存储一棵树
        private int[] parent;
        // 记录树的“重量”
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
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

            // 小树接到大树下面，较平衡
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
        }

        public int find(int x) {
            while (parent[x] != x) {
                // 进行路径压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
    }

}

