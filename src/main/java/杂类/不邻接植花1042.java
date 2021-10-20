package 杂类;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Title: 不邻接植花1042
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-20
 */
public class 不邻接植花1042 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        /*
            限制每个节点的度为3，同时提供四种颜色，因此不需要回溯
            初始化节点，使用map保存节点与其临界点的关系
        */
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] path: paths) {
            int a = path[0] - 1;
            int b = path[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[5];
            /*
                查看当前节点的所有邻接点的色彩
            */
            for (int adj: graph.get(i)) {
                used[res[adj]] = true;
            }
            /*
                在其邻接节点没用的色中选取一个为当前节点染色
            */
            for (int j = 1; j <= 4; j++) {
                if (!used[j]) {
                    res[i] = j;
                }
            }
        }
        return res;
    }
}
