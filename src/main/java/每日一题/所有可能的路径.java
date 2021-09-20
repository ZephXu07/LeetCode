package 每日一题;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 所有可能的路径
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-26
 */
public class 所有可能的路径 {
    private List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        dfs(ans, graph, 0);
        return res;
    }

    private void dfs (LinkedList<Integer> ans, int[][] graph, int cur) {
        ans.add(cur);
        if (cur == graph.length - 1) {
            res.add(new LinkedList<>(ans));
            ans.removeLast();
            return;
        }
        for (int i : graph[cur]) {
            dfs(ans, graph, i);
        }
        ans.removeLast();
    }

}
