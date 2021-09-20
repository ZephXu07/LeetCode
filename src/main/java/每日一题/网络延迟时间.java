package 每日一题;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Title: 网络延迟时间
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-02
 */
public class 网络延迟时间 {
    private static final int INF = Integer.MAX_VALUE / 2;
    /*
        避免相加溢出
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        /*
            找到距离最近的 x ，x 再更新到其他点的距离
            不断重复这一步，直到 点遍历完
         */
        int[][] edge = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(edge[i], INF);
        }
        for (int[] t : times) {
            edge[t[0]][t[1]] = t[2];
        }
        /*
            点 k 到其他点的最小距离
         */
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[k] = 0;
        /*
            因为从自己自身开始，所以到自己的距离是 0
         */

        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {

            int x = -1;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && (x == -1 || dist[j] < dist[x])) {
                    /*
                        第一次或找到更小的
                     */
                    x = j;
                }
            }

            visited[x] = true;

            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], dist[x] + edge[x][j]);
                 /*
                    已知 x 是离 k 最近的，更新 k 到其他点的距离
                  */
            }

        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res == INF ? -1 : res;
    }




    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
//        int[][] times = {{1,2,1}};
//        int n = 2;
//        int k = 1;
//        int[][] times = {{1,2,1}};
//        int n = 2;
//        int k = 2;
        网络延迟时间 res = new 网络延迟时间();
        System.out.println(res.networkDelayTime(times, n, k));
    }
}
