package 每日一题;

import labuladong.Solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Title: 统计不开心的朋友
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-14
 */
public class 统计不开心的朋友 {
//    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
//        int[][] rela = new int[n][n];
//        for (int i = 0; i < preferences.length; i++) {
//            for (int j = 0; j < preferences[i].length; j++) {
//                rela[i][preferences[i][j]] = n - 1 -  j;
//            }
//        }
//        int res = 0;
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < pairs.length; i++) {
//            int x = pairs[i][0];
//            int y = pairs[i][1];
//            for (int j = 0; j < pairs.length; j++) {
//                if (j == i) {
//                    continue;
//                }
//                int u = pairs[j][0];
//                int v = pairs[j][1];
//
//                if (!set.contains(x) && rela[x][u] > rela[x][y] && rela[u][x] > rela[u][v]) {
//                    set.add(x);
//                    res++;
//                }
//                if (!set.contains(x) && rela[x][v] > rela[x][y] && rela[v][x] > rela[v][u]) {
//                    set.add(x);
//                    res++;
//                }
//                if (!set.contains(y) && rela[y][u] > rela[y][x] && rela[u][y] > rela[u][v]) {
//                    set.add(y);
//                    res++;
//                }
//                if (!set.contains(y) && rela[y][v] > rela[y][x] && rela[v][y] > rela[v][u]) {
//                    set.add(y);
//                    res++;
//                }
//            }
//        }
//        return res;
//    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] rela = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                rela[i][preferences[i][j]] = j;
                /*
                    关系越亲近值越小
                 */
            }
        }
        int[] match = new int[n];
        /*
            匹配同伴，从 0 到 n - 1，不用在 pair 中遍历
         */
        for (int[] pair : pairs) {
            int person0 = pair[0], person1 = pair[1];
            match[person0] = person1;
            match[person1] = person0;
        }
        int unhappyCount = 0;
        /*
            计数
         */
        for (int x = 0; x < n; x++) {
            /*
                保证了每个数不重复
             */
            int y = match[x];
            int index = rela[x][y];
            /*
                找到关系值
             */
            for (int i = 0; i < index; i++) {
                /*
                    关系值越大，关系越疏远，
                    如果进入此循环说明
                    x 与 u 的关系比 x 与 y 的关系亲近
                 */
                int u = preferences[x][i];
                int v = match[u];
                if (rela[u][x] < rela[u][v]) {
                    /*
                        如果有比这关系小的，说明
                        u 与 x 的关系比 u 与 v 的关系亲近
                     */
                    unhappyCount++;
                    break;
                    /*
                        找到一个即返回
                        因为关系的大小没有相等的
                     */
                }
            }
        }
        return unhappyCount;
    }


    public static void main(String[] args) {
        统计不开心的朋友 res = new 统计不开心的朋友();
        int n = 6;
        int[][] preferences = {{1,4,3,2,5},{0,5,4,3,2},{3,0,1,5,4},{2,1,4,0,5},{2,1,0,3,5},{3,4,2,0,1}};
        int[][] pairs = {{3, 1}, {2, 0},{5,4}};
        System.out.println(res.unhappyFriends(n, preferences, pairs));
    }
}
