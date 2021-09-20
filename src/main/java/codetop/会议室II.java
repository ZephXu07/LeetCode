package codetop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Title: 会议室II
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-03
 */
public class 会议室II {
//    public int minMeetingRooms(int[][] arr) {
//        int len = arr.length;
//        int[] start = new int[len];
//        int[] end = new int[len];
//        for(int i = 0; i < len; i++) {
//            start[i] = arr[i][0];
//            end[i] = arr[i][1];
//        }
//        Arrays.sort(start);
//        Arrays.sort(end);
//        /*
//            开始、结束时间排血
//         */
//        int i = 0;
//        int j = 0;
//        int res = 0;
//        int max = 0;
//        while (i < len && j < len) {
//            if (start[i] < end[j]) {
//                /*
//                    在一场会议的开始前
//                    还有一场会议没结束
//                    此时需要多一间会议室
//                    开会的下标进入下一个
//                 */
//                max++;
//                i++;
//            } else if (start[i] == end[j]) {
//                /*
//                    一场会议结束，刚好一场会议开始
//                    会议室无缝衔接
//                    开始和结束下标进入下一个
//                 */
//                i++;
//                j++;
//            } else {
//                /*
//                    有一场会议早早结束了，
//                    下一场会议还没开始
//                    此时这间会议室是多余的
//                    结束进入下一个
//                 */
//                max--;
//                j++;
//            }
//            res = Math.max(res, max);
//            /*
//                记录最大的
//             */
//        }
//        return res;
//    }


    public int minMeetingRooms(int[][] arr) {
        if (arr.length==0) {
            return 0;
        }
        /*
            开多少个房间，给每个房间贴上结束的时间，peek为结束最早的会议
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        /*
            开始时间排序
         */
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        queue.offer(arr[0][1]);
        for(int i = 1; i < arr.length; i++) {
            /*
                有空房间，把空房间里的旧会议清除，贴上新会议的结束时间
                空房间：会议的开始时间大于会议的最早结束时间
                堆顶的元素是会议结束时间最早的
                有空房间时把旧的清理了再开新的，相当于用同一间，只是更新了结束时间
             */
            if (arr[i][0] >= queue.peek()) {
                /*
                    一开一关，或者再开，又原本一开始加入了一间房间，所以最小堆永不为空
                 */
                queue.poll();
            }
            /*
                没有空房间，就开一个新房间，贴上新会议的结束时间
             */
            queue.offer(arr[i][1]);

        }
        return queue.size();
        /*
            返回所有会议都开始了（可能有的结束）时房间数量
         */
    }
}
