package labuladong;

import java.util.*;

/**
 * Title: labuladong.IsBipartite
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-21
 */
public class IsBipartite {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        Map<Integer, Integer> colors = new HashMap<>(len + 1);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
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

    public static void main(String[] args) {
        int[][] graph = {{1,3}, {0,2}, {1,3}, {0,2}};
        IsBipartite bipartite = new IsBipartite();
        boolean res = bipartite.isBipartite(graph);
        System.out.println(res);
    }
}
