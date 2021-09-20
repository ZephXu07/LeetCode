package 每日一题;

import java.util.*;

/**
 * Title: 天际线问题
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-13
 */
public class 天际线问题 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
         /*
         https://leetcode-cn.com/problems/the-skyline-problem/solution/you-xian-dui-lie-java-by-liweiwei1419-jdb5/
          */
        int len = buildings.length;
        List<int[]> xy = new ArrayList<>(len * 2);
        /*
            存储每个端点及高度，左端点取相反数，遇到相同端点则消去
         */
        for (int[] b : buildings) {
            xy.add(new int[]{b[0], -b[2]});
            xy.add(new int[]{b[1], b[2]});
        }
        /*
            先端点进行排序，再高度进行排序，左边和低的在前面
         */
        xy.sort((a1, a2) -> {
            if (a1[0] == a2[0]) {
                return a1[1] - a2[1];
            }
            return a1[0] - a2[0];
        });

        PriorityQueue<Integer> heap = new PriorityQueue<>((a1, a2)->a2-a1);
        Map<Integer, Integer> delete = new HashMap<>(len * 2);
        /*
            存放着没有添加新的端点时最高的那个端点的高度
            初始化为 0 ，因为最左边的端点无论高低都会加入结果中
         */
        int pre = 0;
        heap.add(pre);

        List<List<Integer>> res = new LinkedList<>();
        for (int[] point : xy) {
            /*
                遍历每个从左到右（相同则从低到高）的端点
             */
            int p = point[0];
            int h = point[1];
            if (h < 0) {
                heap.offer(-h);
                /*
                    左端点
                 */
            } else {
                /*
                    右端点，即使有多个相同的右端点，也会先消去左右端点更近的楼，即长度更短的楼
                    使用哈希表进行延迟删除，记录要删除的次数
                 */
                delete.put(h, delete.getOrDefault(h, 0) + 1);
            }

            while (!heap.isEmpty()) {
                /*
                    因为存放着 0 ，且楼高度不为0，永远不为空，停着条件是延迟删除的哈希表中没有大顶堆堆顶的值
                 */
                if (delete.containsKey(heap.peek())) {
                    int tmp = delete.get(heap.peek()) - 1;
                    if (tmp == 0) {
                        /*
                            删除次数为0，从延迟删除哈希表中删去
                         */
                        delete.remove(heap.peek());
                    } else {
                        delete.put(heap.peek(), tmp);
                    }
                    heap.poll();
                    /*
                        从堆顶删去
                     */
                } else {
                    break;
                }
            }

            int curH = heap.peek();
            /*
                再加入当前端点后大顶堆的堆顶最大值，即高度最大值，跟加入上一个端点之后造成高度变化的的最大值比较
                如果不同则表示此时有了高低变化，符号天际线的要求，加入结果
             */
            if (curH != pre) {
                res.add(Arrays.asList(p, curH));
                pre = curH;
                /*
                    记录此次的最大值
                 */
            }

        }

        return res;
    }
}
