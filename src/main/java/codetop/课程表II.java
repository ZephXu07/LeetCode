package codetop;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 课程表II
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-02
 */
public class 课程表II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        /*
            入度数组
         */
        boolean[][] edges = new boolean[numCourses][numCourses];
        for (int[] pre : prerequisites) {
            edges[pre[1]][pre[0]] = true;
            inDegree[pre[0]]++;
            /*
                建边与统计入度
             */
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                /*
                    添加入度为 0 的节点
                 */
            }
        }
        int inx = 0;
        int[] res = new int[numCourses];
        /*
            结果数组
         */
        while (!queue.isEmpty()) {
            int point = queue.poll();
            res[inx++] = point;
            /*
                添加到结果
             */
            for (int i = 0; i < numCourses; i++) {
                if (edges[point][i]) {
                    /*
                        遍历相关的边，再消去，入度减一
                     */
                    if (--inDegree[i] == 0) {
                        queue.offer(i);
                        /*
                            入度为 0 继续添加到队列中
                         */
                    }
                }
            }
        }
        if (inx != numCourses) {
            /*
                不能走完所有课，返回空
             */
            return new int[0];
        }
        return res;
    }
}
