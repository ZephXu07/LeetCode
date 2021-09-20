package 每日一题;

import java.util.*;

/**
 * Title: 找到最终的安全状态
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-05
 */
public class 找到最终的安全状态 {
//    private int[] color;
//    public List<Integer> eventualSafeNodes(int[][] graph) {
//        List<Integer> res;
//        res = new LinkedList<>();
//        color = new int[graph.length];
//        for (int i = 0; i < graph.length; i++) {
//            if (dfs(graph, i)) {
//                res.add(i);
//            }
//        }
//        return res;
//    }
//
//    private boolean dfs (int[][] graph, int inx) {
//        if (color[inx] != 0) {
//            return color[inx] == 2;
//        }
//        color[inx] = 1;
//        for (int g : graph[inx]) {
//            if (!dfs(graph, g)) {
//                return false;
//            }
//        }
//        color[inx] = 2;
//        return true;
//    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
         /*
            拓扑排序：找到入度为0的点
            1.找出入度为0的点，加入队列，先进先出
            2.根据这些点的边到达下一个点，消去此边，如果下一个点入度为0，再加入队列
            3.直到队列为空

            由题有当一个点的出度为0肯定是结果，如果一个点指向的边的点都是出度为0的点，也是结果

            于是整个图反向，单向边逆转，出度变入度，入度变出度

            使用拓扑排序找到入度为0的点，即为结果
          */
        List<List<Integer>> contrary = new ArrayList<>();
        int len = graph.length;
        for (int i = 0; i < len; i++) {
            contrary.add(new ArrayList<>());
        }
        int[] inDegree = new int[len];
        for (int i = 0; i < len; i++) {
            inDegree[i] = graph[i].length;
            for (int j = 0; j < graph[i].length; j++) {
                contrary.get(graph[i][j]).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int inx = queue.poll();
            for (int i : contrary.get(inx)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (inDegree[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        找到最终的安全状态 res = new 找到最终的安全状态();
//        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
//        int[][] graph = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        int[][] graph = {{},{0,2,3,4},{3},{4},{}};
        List<Integer> integers = res.eventualSafeNodes(graph);
        for (int i : integers) {
            System.out.print(i + "\t");
        }
    }
}
