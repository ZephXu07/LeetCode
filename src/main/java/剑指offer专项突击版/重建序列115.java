package 剑指offer专项突击版;

import java.util.*;

/**
 * Title: 重建序列115
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-08
 */
public class 重建序列115 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        /*
            拓扑排序
         */
        int n = org.length;
        Set<Integer>[] edges = new HashSet[n + 1];
        /*
            避免 -1
         */
        int[] degree = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            degree[i] = -1;
        }
        int[] node = new int[n + 1];
        /*
            判断序列出现的数种类是不是一致
         */
        int count = 0;
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                int cur = seq.get(i);
                if (cur <= 0 || cur > n) {
                    return false;
                }
                if (null == edges[cur]) {
                    edges[cur] = new HashSet<>();
                }
                if (degree[cur] == -1) {
                    /*
                        统计入度为 0 的数字
                     */
                    degree[cur] = 0;
                }
                if (++node[cur] == 1) {
                    count++;
                }
                if (i == 0) {
                    continue;
                }
                int pre = seq.get(i - 1);
                if (!edges[pre].contains(cur)) {
                    /*
                        避免同样的序列造成入度数增加
                     */
                    edges[pre].add(cur);
                    degree[cur]++;
                }
            }
        }
        if (count != n) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int inx = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                /*
                    一个时刻只能有一个初始数
                 */
                return false;
            }
            int tmp = queue.poll();
            if (org[inx++] != tmp) {
                /*
                    是否与题目给的顺序一致
                 */
                return false;
            }

            for (int e : edges[tmp]) {
                degree[e]--;
                if (degree[e] == 0) {
                    queue.offer(e);
                }
            }
        }
        return inx == n;
        /*
            是否全部遍历完
         */
    }

    public static void main(String[] args) {
        重建序列115 res = new 重建序列115();
        int[] org = {4,1,5,2,6,3};
        List<List<Integer>> seqs = Arrays.asList(Arrays.asList(5,2,6,3), Arrays.asList(4,1,5,2));
        System.out.println(res.sequenceReconstruction(org, seqs));
    }
}
