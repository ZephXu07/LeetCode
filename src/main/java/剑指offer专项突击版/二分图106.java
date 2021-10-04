package 剑指offer专项突击版;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Title: 二分图106
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-04
 */
public class 二分图106 {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        Map<Integer, Integer> colors = new HashMap<>(len);
        /*
            点 --> 颜色
         */
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (colors.containsKey(i)) {
                /*
                    已经涂色了，跳过
                 */
                continue;
            }
            colors.put(i, 0);
            /*
                为什么只涂 0
                因为涂 1 的在后续的遍历中已经涂过了
                然后在上面 continue 里面跳过了
                加入队列
             */
            queue.add(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int color = colors.get(cur);
                int newColor = color ^ 1;
                /*
                    0 --> 1
                    1 --> 0

                 */
                for (int j : graph[cur]) {
                    /*
                        边的另一端是另外的颜色
                     */
                    if (!colors.containsKey(j)) {
                        /*
                            没涂过，涂色
                            加入队列
                         */
                        colors.put(j, newColor);
                        queue.add(j);
                    } else if (colors.get(j) != newColor){
                        /*
                            已经上色了，且不是边的另外一种颜色，
                            则不满足要求
                         */
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
