package 每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: 连接所有点的最小费用
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-19
 */
public class 连接所有点的最小费用 {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        Edge[] edges = new Edge[len * (len - 1) / 2];
        int inx = 0;
        int tmp;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                tmp = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges[inx++] = new Edge(i, j, tmp);
            }
        }
        Arrays.sort(edges, (e1, e2) -> {
            return e1.value - e2.value;
        });
        int start;
        int end;
        int sum = 0;
        UnionFind uF = new UnionFind(len);
        for (Edge e : edges) {
            start = e.startInx;
            end = e.endInx;
            if (uF.find(start) != uF.find(end)) {
                sum += e.value;
                uF.union(start, end);
            }
        }
        return sum;
    }

//    public static void main(String[] args) {
//        连接所有点的最小费用 res = new 连接所有点的最小费用();
//        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
//        System.out.println(res.minCostConnectPoints(points));
//    }

    private class Edge {
        private int startInx;
        private int endInx;

        private int value;

        public Edge(int startInx, int endInx, int value) {
            this.startInx = startInx;
            this.endInx = endInx;
            this.value = value;
        }

    }

    private class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int len) {
            parent = new int[len + 1];
            size = new int[len + 1];
            for (int i = 0; i < len + 1; i++) {
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
}
