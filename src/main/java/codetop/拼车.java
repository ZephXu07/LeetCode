package codetop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: 拼车
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-21
 */
public class 拼车 {
//    public boolean carPooling(int[][] trips, int capacity) {
//        Map<Integer, Integer> getOn = new HashMap<>();
//        /*
//            上车的时间及人
//         */
//        Map<Integer, Integer> getOff = new HashMap<>();
//         /*
//            下车的时间及人
//         */
//        int start = 1001;
//        int end = -1;
//        /*
//            找到起始和结束时间
//         */
//        for (int[] t : trips) {
//            getOn.put(t[1], getOn.getOrDefault(t[1], 0) + t[0]);
//            getOff.put(t[2], getOff.getOrDefault(t[2], 0) + t[0]);
//            start = Math.min(start, t[1]);
//            end = Math.max(end, t[1]);
//        }
//        int cur = 0;
//        for (int i = start; i <= end; i++) {
//            /*
//                枚举时间，改变车上的人数量
//                大于容量则失败
//             */
//            if (getOff.containsKey(i)) {
//                cur -= getOff.get(i);
//            }
//            if (getOn.containsKey(i)) {
//                cur += getOn.get(i);
//            }
//            if (cur > capacity) {
//                return false;
//            }
//        }
//        return true;
//
//    }


    public boolean carPooling(int[][] trips, int capacity) {
        /*
            diff[] 差分数组
            下标对应时间，值对应车上还剩余空位
            记录容量的变化
            上车容量 -
            下车容量 +
            所以当 capacity 小于 0 表示位置不够
         */
        int[] diff = new int[1001];
        for (int[] t : trips) {
            diff[t[1]] -= t[0];
            diff[t[2]] += t[0];
        }
        for (int d : diff) {
            capacity += d;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        拼车 res = new 拼车();
        int[][] trips = {{2,1,5},{3,3,7}};
        System.out.println(res.carPooling(trips, 4));
    }
}
