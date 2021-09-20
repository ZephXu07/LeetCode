package codetop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: 除法求值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-13
 */
public class 除法求值 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int eLen = equations.size();
        UnionFind uf = new UnionFind(2 * eLen);
        Map<String, Integer> memo = new HashMap<>(2 * eLen);
        /*
            字符映射到数字上
            方便使用并查集
         */
        int count = 0;
        for (int i = 0; i < eLen; i++) {
            List<String> tmp = equations.get(i);
            String val1 = tmp.get(0);
            String val2 = tmp.get(1);
            if (!memo.containsKey(val1)) {
                memo.put(val1, count++);
            }
            if (!memo.containsKey(val2)) {
                memo.put(val2, count++);
            }
            uf.union(memo.get(val1), memo.get(val2), values[i]);
        }
        int qLen = queries.size();
        double[] ans = new double[qLen];
        for (int i = 0; i < qLen; i++) {
            List<String> tmp = queries.get(i);
            String val1 = tmp.get(0);
            String val2 = tmp.get(1);
            Integer k1 = memo.get(val1);
            Integer k2 = memo.get(val2);
            if (null == k1 || null == k2) {
                ans[i] = -1;
            } else {
                ans[i] = uf.isConnected(k1, k2);
            }
        }
        return ans;
    }

    private class UnionFind {
        private int[] parent;
        private double[] weight;
        public UnionFind(int eLen) {
            parent = new int[eLen];
            weight = new double[eLen];
            for (int i = 0; i < eLen; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public void union(int p, int q, double value) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            /*
                       w[rootP]
                rootP  ------>  rootQ
                 ^              ^
       w[P]      |     val     | w[Q]
               P    ----->   Q

               w[P] * w[rootP] = val * w[Q]
               w[rootP] = w[Q] * val / w[P]
             */
            }
            parent[rootP] = rootQ;
            weight[rootP] = weight[q] * value / weight[p];
        }

        public int find(int x) {
            /*
                返回跟结点，及此节点到根节点路径的权重的乘积
                P ----> rootP
                  w[P]
             */
            if (parent[x] != x) {
                int origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                /*
                    (p / rootP) / (q / rootQ)
                    = (p / rootP) * (rootQ / q)
                    = p / q
                 */
                return weight[p] / weight[q];
            } else {
                return -1.0d;
            }
        }

    }
}
