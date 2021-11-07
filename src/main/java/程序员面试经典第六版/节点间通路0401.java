package 程序员面试经典第六版;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 节点间通路0401
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-06
 */
public class 节点间通路0401 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<Integer>[] edges = new List[n];
        for (int[] g : graph) {
            if (null == edges[g[0]]) {
                edges[g[0]] = new LinkedList<>();
            }
            edges[g[0]].add(g[1]);
        }
        boolean[] visited = new boolean[n];
        return dfs(edges, visited, start, target);
    }

    private boolean dfs (List<Integer>[] edges, boolean[] visited, int inx, int target) {
        if (inx == target) {
            return true;
        }
        if (null == edges[inx]) {
            return false;
        }
        visited[inx] = true;
        for (int to : edges[inx]) {
            if (visited[to]) {
                continue;
            }
            if (dfs(edges, visited, to, target)) {
                return true;
            }
        }
        visited[inx] = false;
        return false;
    }


}
