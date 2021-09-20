package codetop;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 课程表
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-10
 */
public class 课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        boolean[][] edges = new boolean[numCourses][numCourses];
        for (int[] pre : prerequisites) {
            edges[pre[1]][pre[0]] = true;
            inDegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        /*
            如果访问的节点等于课程数，则说明已经找到一种方法了
            不需要再次遍历入度
         */
        while (!queue.isEmpty()) {
            int point = queue.poll();
            visited++;
            for (int i = 0; i < numCourses; i++) {
                if (edges[point][i]) {
                    if (--inDegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
//        for (int i = 0; i < numCourses; i++) {
//            if (inDegree[i] != 0) {
//                return false;
//            }
//        }
//        return true;
        return visited == numCourses;
    }
}
