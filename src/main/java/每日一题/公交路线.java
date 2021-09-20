package 每日一题;

import java.util.*;

/**
 * Title: 公交路线
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-28
 */
public class 公交路线 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        /*
            站点对应路线，通过站点存储的路线，遍历是否能到达终点
         */
        if (source == target) {
            /*
                起点终点一样直接返回0
             */
            return 0;
        }
        /*
            车站对应路线，即路线经过此站
         */
        Map<Integer, Set<Integer>> sToR = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            /*
                第几条路线
             */
            for (int j = 0; j < routes[i].length; j++) {
                /*
                    路线里的第几站
                 */
                Set<Integer> route;
                if (!sToR.containsKey(routes[i][j])) {
                    /*
                        routes[i][j] 车站号
                        不存在这个车站，新建 Set 来存储有这个车站的路线
                     */
                    route = new HashSet<>();
                } else {
                    /*
                        已经存在这个车站，提取路线的哈希表
                     */
                    route = sToR.get(routes[i][j]);
                }
                route.add(i);
                /*
                    加入路线哈希表
                 */
                sToR.put(routes[i][j], route);
                /*
                    加入站点路线哈希表
                 */
            }
        }
        if (!sToR.containsKey(source) || !sToR.containsKey(target)) {
            /*
                起点或重点车站不存在直接返回
             */
            return -1;
        }
        Set<Integer> visited = new HashSet<>();
        /*
            走过的车站，避免死循环
         */
        Set<Integer> s1 = sToR.get(source);
        /*
            双向遍历，起点
         */
        Set<Integer> s2 = sToR.get(target);
        /*
            终点
         */
        int count = 1;
        /*
            只要不是起点等于终点，初始值就是1
         */
        while (!s1.isEmpty() && !s2.isEmpty()) {
            /*
                当两个必须都有值，一个空了就说明都到不了
             */
            Set<Integer> tmp = new HashSet<>();
            /*
             一个方向遍历的新增站点
             */
            for (int s : s1) {
                if (visited.contains(s)) {
                    /*
                        走过，直接下一个枚举的站点
                     */
                    continue;
                }
                if (s2.contains(s)) {
                    /*
                        双向 bfs 有交集，说明存在路线，且一定是最短的，又因为是来回遍历都增长一次，直接返回count
                     */
                    return count;
                }
                for (int i = 0; i < routes[s].length; i++) {
                    /*
                        遍历经过车站s的路线
                     */
                    int stop = routes[s][i];
                    Set<Integer> route = sToR.get(stop);
                    /*
                        过车站s的路线的其他没走过的车站
                     */
                    for (int r : route) {
                        if (visited.contains(r)) {
                            continue;
                        }
                        /*
                                没有遍历过加入下一次遍历的哈希表
                             */
                        tmp.add(r);
                    }
                }
                /*
                    重点，再遍历过每一个经过 s 的路线的所有其他站点后才把当前站点 s 加入已遍历的站点
                 */
                visited.add(s);
            }
            count++;
            /*
                根据大小交换遍历集合
             */
            if (s2.size() >= tmp.size()) {
                s1 = tmp;
            } else {
                s1 = s2;
                s2 = tmp;
            }
        }
        /*
        最终找不到才返回 - 1
         */
        return -1;

    }

    public static void main(String[] args) {
        公交路线 res = new 公交路线();
        int[][] routes = {{10,13,22,28,32,35,43},
        {2,11,15,25,27},
        {6,13,18,25,42},
        {5,6,20,27,37,47},
        {7,11,19,23,35},
        {7,11,17,25,31,43,46,48},
        {1,4,10,16,25,26,46},
        {7,11},
        {3,9,19,20,21,24,32,45,46,49},
        {11,41}
        };
        int source = 37;
        int target = 43;
        System.out.println(res.numBusesToDestination(routes, source, target));
    }


}
