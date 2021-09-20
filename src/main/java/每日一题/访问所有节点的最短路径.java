package 每日一题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Title: 访问所有节点的最短路径
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-06
 */
public class 访问所有节点的最短路径 {
    public int shortestPathLength(int[][] graph) {
        int len = graph.length;
        /*
            点数
         */
        boolean[][] visited = new boolean[len][1 << len];
        /*
            每个点为起始的访问所有点的路径，
            1 << len
            由于点从 0 下标开始，所以使用类似二进制的方法，哪一个点被访问了二进制上为1
            最后代表的十进制的数即设为 true，即当前访问点是 i 点，访问了 j 代表的二进制的点的访问路径
         */
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            queue.offer(new int[]{i, 1 << i, 0});
            /*
               int[0] 当前访问点
               int[1] 路径，二进制计算，使用十进制表示
               int[2] 步数
             */
            visited[i][1 << i] = true;
            /*
                当前访问的点是 i点，路径为 i 代表的二进制位上值 1
             */

            /*
                当前访问点为i, 访问了 i 的路径都加入搜索集
             */
        }
        int res = 0;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int point = arr[0];
            int track = arr[1];
            int step = arr[2];
            /*
                当前访问点，路径，步数
             */
            if (track == (1 << len) -1) {
                /*
                    先进先出，一开始是每个起点的路径都进行搜索，每次的步数都加 1
                    先搜索到每个点都有的路径的步数肯定是最小的
                 */
                res = step;
                break;
            }

            for (int g : graph[point]) {
                int tra = track | (1 << g);
                /*
                    与 point 有边相邻的点被搜索了
                 */
                if (!visited[g][tra]) {
                    /*
                        如果当前点和当前的路径的集合没被搜索过，进行搜索
                     */
                    queue.offer(new int[]{g, tra, step + 1});
                    /*
                        添加到新的搜索集，当前点是g，访问的点为二进制代表的 tra，再一次访问了，步数增加
                     */
                    visited[g][tra] = true;
                    /*
                        已经访问了，剪枝
                     */
                }
            }

        }
        return res;


    }


    public static void main(String[] args) {
        System.out.println(1 << 12);
    }
}
