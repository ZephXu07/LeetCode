package codetop;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 课程表2
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-10
 */
public class 课程表2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int inx = 0;
        int[] res = new int[numCourses];
        while (!queue.isEmpty()) {
            int point = queue.poll();
            res[inx++] = point;
            for (int i = 0; i < numCourses; i++) {
                if (edges[point][i]) {
                    if (--inDegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        if (inx != numCourses) {
            return new int[0];
        }
        return res;
    }
}
