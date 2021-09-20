package 每日一题;

import java.util.*;

/**
 * Title: 除法求值
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-06
 */
public class 除法求值 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equLen = equations.size();
        UnionFind unionFind = new UnionFind(2 * equLen);
        Map<String, Integer> memo = new HashMap<>(2 * equLen);
        int count = 0;
        for (int i = 0; i < equLen; i++) {
            List<String> tmp = equations.get(i);
            String value1 = tmp.get(0);
            String value2 = tmp.get(1);
            if (!memo.containsKey(value1)) {
                memo.put(value1, count++);
            }
            if (!memo.containsKey(value2)) {
                memo.put(value2, count++);
            }
            unionFind.union(memo.get(value1), memo.get(value2), values[i]);
        }
        int queLen = queries.size();
        double[] ans = new double[queLen];
        for (int i = 0; i < queLen; i++) {
            List<String> tmp = queries.get(i);
            String value1 = tmp.get(0);
            String value2 = tmp.get(1);
            Integer k1 = memo.get(value1);
            Integer k2 = memo.get(value2);
            if (null == k1 || null == k2) {
                ans[i] = -1;
            } else {
                ans[i] = unionFind.isConnected(k1, k2);
            }
        }
        return ans;
    }

    private class UnionFind {
        private int[] parent;
        private double[] weight;
        public UnionFind(int equLen) {
            parent = new int[equLen];
            weight = new double[equLen];
            for (int i = 0; i < equLen; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public void union(int p, int q, double value) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            weight[rootP] = weight[q] * value / weight[p];
        }

        public int find(int x) {
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
                return weight[p] / weight[q];
            } else {
                return -1;
            }
        }

    }


    public static void main(String[] args) {
        除法求值 res = new 除法求值();
        List<List<String>> equations = new LinkedList<>();
        List<String> tmp = new LinkedList<>();
        tmp.add("x1");
        tmp.add("x2");
        equations.add(tmp);
        tmp = new LinkedList<>();
        tmp.add("x2");
        tmp.add("x3");
        equations.add(tmp);
        tmp = new LinkedList<>();
        tmp.add("x3");
        tmp.add("x4");
        equations.add(tmp);
        tmp = new LinkedList<>();
        tmp.add("x4");
        tmp.add("x5");
        equations.add(tmp);

        double[] values = {3.0,4.0,5.0,6.0};

        List<List<String>> queries = new LinkedList<>();
        tmp = new LinkedList<>();
        tmp.add("x1");
        tmp.add("x5");
        queries.add(tmp);
        tmp = new LinkedList<>();
        tmp.add("x5");
        tmp.add("x2");
        queries.add(tmp);
        tmp = new LinkedList<>();
        tmp.add("x2");
        tmp.add("x4");
        queries.add(tmp);
        tmp = new LinkedList<>();
        tmp.add("x2");
        tmp.add("x2");
        queries.add(tmp);
        tmp = new LinkedList<>();
        tmp.add("x2");
        tmp.add("x9");
        queries.add(tmp);
        tmp = new LinkedList<>();
        tmp.add("x9");
        tmp.add("x9");
        queries.add(tmp);

        System.out.println(Arrays.toString(res.calcEquation(equations, values, queries)));
    }
}
