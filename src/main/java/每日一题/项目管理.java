package 每日一题;

import java.util.*;

/**
 * Title: 项目管理
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-18
 */
public class 项目管理 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < group.length; i++) {
            if (-1 == group[i]) {
                group[i] = m;
                m ++;
            }
        }
        //给没有属于组的项目自定义分组

        List<Integer>[] groupAdj = new LinkedList[m];
        List<Integer>[] itemAdj = new LinkedList[n];
        for (int i = 0; i < m; i++) {
            groupAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            itemAdj[i] = new LinkedList<>();
        }
        //实例化组和项目的邻接表

        int[] groupInDegree = new int[m];
        int[] itemInDegree = new int[n];
        int len = group.length;
        for (int i = 0; i < len; i++) {
            int curGroup = group[i];
            for (int befItem : beforeItems.get(i)) {
                int befGroup = group[befItem];
                if (curGroup == befGroup) {
                    continue;
                }
                groupAdj[befGroup].add(curGroup);
                groupInDegree[curGroup]++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int item : beforeItems.get(i)) {
                itemAdj[item].add(i);
                itemInDegree[i]++;
            }
        }
        //建图和统计入度数组

        List<Integer> groupList = topologicalSort(groupAdj, groupInDegree, m);
        if (groupList.size() == 0) {
            return new int[0];
        }
        List<Integer> itemList = topologicalSort(itemAdj, itemInDegree, n);
        if (itemList.size() == 0) {
            return new int[0];
        }
        //得到组和项目的拓扑排序结果

        Map<Integer, List<Integer>> groupToItems = new HashMap<>();
        for (int i:itemList) {
            groupToItems.computeIfAbsent(group[i], key -> new LinkedList<>()).add(i);
        }
        //根据项目的拓扑结果与项目与组的多对一关系反向建立组与项目的一对多关系

        List<Integer> res = new LinkedList<>();
        for (int i: groupList) {
            List<Integer> item = groupToItems.getOrDefault(i, new LinkedList<>());
            res.addAll(item);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
        //将组的拓扑排序替换成项目的拓扑排序结果

    }

    //拓扑排序
    private List<Integer> topologicalSort(List<Integer>[] adj, int[] inDegree, int n) {
        List<Integer> res = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int front = queue.poll();
            res.add(front);
            for (int next : adj[front]) {

                if (--inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (res.size() == n) {
            return res;
        }
        return new LinkedList<>();
    }
}
