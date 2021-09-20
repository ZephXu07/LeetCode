package 每日一题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 找到最小生成树里的关键边和伪关键边
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-21
 */
public class 找到最小生成树里的关键边和伪关键边 {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int len = edges.length;
        int[][] newEdges = new int[len][4];
        for (int i = 0; i < len; i++) {
            System.arraycopy(edges[i], 0, newEdges[i], 0, 3);
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, Comparator.comparingInt(e -> e[2]));
        int minSum = 0;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < len; i++) {

            if (uf.union(newEdges[i][0], newEdges[i][1])) {
                minSum += newEdges[i][2];
            }
        }
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            res.add(new LinkedList<>());
        }
        for (int i = 0; i < len; i++) {
            UnionFind uF = new UnionFind(n);
            int sum = 0;
            for (int j = 0; j < len; j++) {
                if (i != j && uF.union(newEdges[j][0], newEdges[j][1])) {
                    sum += newEdges[j][2];
                }
            }
            if (uF.count != 1 || sum > minSum) {
                res.get(0).add(newEdges[i][3]);
                continue;
            }


            uF = new UnionFind(n);
            uF.union(newEdges[i][0], newEdges[i][1]);
            sum = newEdges[i][2];
            for (int j = 0; j < len; j++) {
                if (i != j && uF.union(newEdges[j][0], newEdges[j][1])) {
                    sum += newEdges[j][2];
                }
            }
            if (sum == minSum) {
                res.get(1).add(newEdges[i][3]);
            }
        }

        return res;
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

    public static void main(String[] args) {
        找到最小生成树里的关键边和伪关键边 res = new 找到最小生成树里的关键边和伪关键边();
        int n = 5;
        int[][] edges = {{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};
        List<List<Integer>> listList = res.findCriticalAndPseudoCriticalEdges(n, edges);
        for (List<Integer> l : listList) {
            for (int i : l) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
