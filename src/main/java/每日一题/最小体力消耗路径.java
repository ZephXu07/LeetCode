package 每日一题;

import java.util.*;

/**
 * Title: 最小体力消耗路径
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-29
 */
public class 最小体力消耗路径 {
    public int minimumEffortPathUnionFind(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        List<int[]> edges = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int inx = i * cols + j;
                if (i > 0) {
                    edges.add(new int[] {inx - cols, inx, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    edges.add(new int[] {inx - 1, inx, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }
        edges.sort(Comparator.comparingInt(edge -> edge[2]));
        UnionFind uF = new UnionFind(rows * cols);
        int end = cols * rows - 1;
        for (int[] e: edges) {
            uF.union(e[0], e[1]);
            if (uF.isConnectd(0, end)) {
                return e[2];
            }
        }
        return 0;
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


    private static final int[][] DIRECTION = {{-1,0},{1,0},{0, -1},{0,1}};
    private int rows;
    private int cols;
    private int[][] heights;
    public int minimumEffortPathBinarySearch(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        this.heights = heights;
        int low = 0;
        int high = 999999;
        int mid;
        while (low <= high) {
            boolean[][] visited = new boolean[rows][cols];
            mid = (low + high) / 2;
            if (dfs(visited, 0, 0, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean dfs(boolean[][] visited, int x, int y, int mid) {
        if (x == rows - 1 && y == cols - 1) {
            return true;
        }
        for (int i = 0; i < 4; ++i) {
            int nx = x + DIRECTION[i][0];
            int ny = y + DIRECTION[i][1];
            if (inArea(nx, ny) && !visited[nx][ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid) {
                visited[x][y] = true;
                if (dfs(visited, nx, ny, mid)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public int minimumEffortPathDijkstra(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((edge1, edge2) -> edge1[2] - edge2[2]);
        pq.offer(new int[]{0, 0, 0});

        int[] dist = new int[m * n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        boolean[] seen = new boolean[m * n];

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int x = edge[0], y = edge[1], d = edge[2];
            int id = x * n + y;
            if (seen[id]) {
                continue;
            }
            if (x == m - 1 && y == n - 1) {
                break;
            }
            seen[id] = true;
            for (int i = 0; i < 4; ++i) {
                int nx = x + DIRECTION[i][0];
                int ny = y + DIRECTION[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && Math.max(d, Math.abs(heights[x][y] - heights[nx][ny])) < dist[nx * n + ny]) {
                    dist[nx * n + ny] = Math.max(d, Math.abs(heights[x][y] - heights[nx][ny]));
                    pq.offer(new int[]{nx, ny, dist[nx * n + ny]});
                }
            }
        }

        return dist[m * n - 1];
    }

    public static void main(String[] args) {
        最小体力消耗路径 res = new 最小体力消耗路径();
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(res.minimumEffortPathUnionFind(heights));
        System.out.println(res.minimumEffortPathBinarySearch(heights));
    }

}
