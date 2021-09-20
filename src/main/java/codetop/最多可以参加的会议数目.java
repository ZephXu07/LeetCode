package codetop;

import java.util.*;

/**
 * Title: 最多可以参加的会议数目
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-04
 */
public class 最多可以参加的会议数目 {
//    public int maxEvents(int[][] events) {
//        /*
//            对于每一个时间点，所有在当前时间及之前时间开始，
//            并且在当前时间还未结束的会议都是可参加的。
//            显然，在所有可参加的会议中，选择结束时间最早的会议是最优的，
//            因为其他会议还有更多的机会可以去参加。
//         */
//        Map<Integer, List<Integer>> map = new HashMap<>(events.length);
//        int start = 100000;
//        int end = 0;
//        for (int[] e : events) {
//            if (map.containsKey(e[0])) {
//                map.get(e[0]).add(e[1]);
//            } else {
//                List<Integer> tmp = new LinkedList<>();
//                tmp.add(e[1]);
//                map.put(e[0], tmp);
//            }
//            start = Math.min(start, e[0]);
//            end = Math.max(end, e[1]);
//        }
//        /*
//            哈希表记录起始时间与其对应的会议结束时间链表
//         */
//
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        /*
//            小顶堆，弹出会议结束时间最早的
//         */
//        int res = 0;
//        while (start <= end) {
//            /*
//                遍历所有时间点
//             */
//            if (map.containsKey(start)) {
//                /*
//                    如果这个时间点有会议，就加入小顶堆中
//                 */
//                List<Integer> list = map.get(start);
//                for (int i : list) {
//                    minHeap.offer(i);
//                }
//            }
//
//            while (!minHeap.isEmpty() && start > minHeap.peek()) {
//                /*
//                    弹出所有结束时间在当前时间之前的
//                 */
//                minHeap.poll();
//            }
//
//            if (!minHeap.isEmpty()) {
//                /*
//                    如果当前队列不为空，
//                    参加一个结束时间最早的会议
//                 */
//                minHeap.poll();
//                res++;
//            }
//            start++;
//            /*
//                时间移动
//             */
//        }
//        return res;
//
//
//    }

    public int maxEvents(int[][] events) {
        /*
            对于每一个时间点，所有在当前时间及之前时间开始，
            并且在当前时间还未结束的会议都是可参加的。
            显然，在所有可参加的会议中，选择结束时间最早的会议是最优的，
            因为其他会议还有更多的机会可以去参加。
         */
        Arrays.sort(events, Comparator.comparingInt(e->e[0]));
        /*
            时间换空间，使用排序而不是map
         */
        int start = 100000;
        int end = 0;
        for (int[] e : events) {
            start = Math.min(start, e[0]);
            end = Math.max(end, e[1]);
        }
        /*
            哈希表记录起始时间与其对应的会议结束时间链表
         */

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        /*
            小顶堆，弹出会议结束时间最早的
         */
        int res = 0;
        int inx = 0;
        while (start <= end) {
            /*
                遍历所有时间点
             */
            while (inx < events.length && events[inx][0] == start) {
                /*
                    如果这个时间点有会议，就加入小顶堆中
                 */
                minHeap.offer(events[inx++][1]);

            }

            while (!minHeap.isEmpty() && start > minHeap.peek()) {
                /*
                    弹出所有结束时间在当前时间之前的
                 */
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                /*
                    如果当前队列不为空，
                    参加一个结束时间最早的会议
                 */
                minHeap.poll();
                res++;
            }
            start++;
            /*
                时间移动
             */
        }
        return res;


    }

    public static void main(String[] args) {
        最多可以参加的会议数目 res = new 最多可以参加的会议数目();
        int[][] e = {{1,2},{2,3},{3,4}};
        System.out.println(res.maxEvents(e));
    }
}
