package labuladong;

import java.util.*;

/**
 * Title: labuladong.PossibleBipartition
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-21
 */
public class PossibleBipartition {
    private List<Integer>[] graph;
    private Map<Integer, Integer> colors;

    public boolean possibleBipartitionDfs(int N, int[][] dislikes) {
        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge:dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        colors = new HashMap<>(N + 1);
        for (int i = 1; i < N + 1; i++) {
            if (!colors.containsKey(i) && !dfs(i, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int color) {
        if (colors.containsKey(node)) {
            return colors.get(node) == color;
        }
        colors.put(node, color);
        for (int i:graph[node]) {
            if (!dfs(i, color ^ 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean possibleBipartitionBfs(int N, int[][] dislikes) {
        graph = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge:dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        colors = new HashMap<>(N + 1);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (colors.containsKey(i)) {
                continue;
            }
            colors.put(i, 0);
            queue.add(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int color = colors.get(cur);
                int newColor = color ^ 1;
                for (int j:graph[cur]) {
                    if (!colors.containsKey(j)) {
                        colors.put(j, newColor);
                        queue.add(j);
                    } else if (colors.get(j) != newColor){
                        return false;
                    }
                }
            }
        }
        return true;
    }



    public boolean possibleBipartitionUnionFind(int N, int[][] dislikes) {
        UnionFind unionFind = new UnionFind(N * 2 + 1);
        int x;
        int y;
        int m;
        int n;
        for (int i = 0; i < dislikes[i].length; i++) {
            x = unionFind.find(dislikes[i][0]);
            y = unionFind.find(dislikes[i][1]);
            m = unionFind.find(dislikes[i][0] + N);
            n = unionFind.find(dislikes[i][1] + N);
            if (x == y) {
                return false;
            } else {
                unionFind.union(y, m);
                unionFind.union(x, n);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] dislike = {{1,2},{1,3},{2,3}};
        PossibleBipartition p = new PossibleBipartition();
        boolean ans = p.possibleBipartitionDfs(N, dislike);
        System.out.println(ans);
        ans = p.possibleBipartitionBfs(N, dislike);
        System.out.println(ans);
        ans = p.possibleBipartitionUnionFind(N, dislike);
        System.out.println(ans);

    }

}
class UnionFind {
    private int count;
    private int[] parent;
    private int[] size;

    public UnionFind(int count) {
        this.count = count;
        parent = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (size[pRoot] > size[qRoot]) {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
        count --;
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }
}
