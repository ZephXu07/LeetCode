package 剑指offer专项突击版;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Title: 值和下标之差都在给定的范围内057
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-08
 */
public class 值和下标之差都在给定的范围内057 {
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//         /* 题目abs(nums[i] - nums[j]) <= t
//            转化不等式为 nums[i] + t >= nums[j] && nums[i] - t <= nums[j]
//
//            因为TreeSet（Map没有因此放弃）提供的ceiling方法返回的是大于等于的，又因为使用滑动窗口，所以需要进行转化
//
//            同时 abs (i - j) <= k，即滑动窗口的宽度为 k，TreeSet的长度为k最大，大于k 时移除最左边，坐标为 i - k
//         */
//
//         int len = nums.length;
//         // 特判
//         if (len == 0 || k <= 0 || t < 0) {
//             return false;
//         }
//
//         TreeSet<Long> set = new TreeSet<>();
//         for (int i = 0; i < nums.length; i++) {
//             Long ceil = set.ceiling((long)nums[i] - t);
//             /*
//                可能不存在
//                寻找大于等于 x - t 的第一个元素
//              */
//
//             if (null != ceil && ceil <= (long)nums[i] + t) {
//                 /*
//                    如果 大于等于 x - t 的第一个元素存在，则左边界 x-t 找到了
//                    x 无论正负还是 0
//                    当 t 大于 0 时，x - t < x + t
//                    当 t == 0 时，x - t == x + t
//                    所以此处需要判断一下
//                  */
//                 return true;
//             }
//             /*
//                枚举以 nums[i] 为右边界的窗口长度为 k + 1 的左侧
//                是否均在 [nums[i] - t, nums[i] + t]范围内
//              */
//
//             set.add((long)nums[i]);
//             //添加到窗口
//             if (set.size() > k) {
//                 set.remove((long)nums[i - k]);
//             }
//         }
//         return false;
//    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        /*  abs(nums[i] - nums[j]) <= t，假设t = 2，则差的绝对值可以是0，1，2

            运用桶排序思想，坐标为inx的桶的范围则是 第一个创建桶的数的左右，即 [x - t, x + t]，当这个桶存在，则说明要存入第二个数，满足题意

            t如上， 每一个数 x， inx桶坐标， b如上，差值绝对值， （t + 1）桶容量
            x = (t + 1) * inx + b，
            如0， 1， 2在 0桶
            此时负数 -1， -2， -3 在 -1 桶
            因此坐标计算 inx， 当 x >= 0 ： x / (t + 1)
                            当 x < 0：( x + 1 ) / (t + 1) - 1


            abs (i - j) <= k是桶的数量，即坐标差绝对值
         */
        int size = t + 1;
        //桶容量
        Map<Long, Long> map = new HashMap<>(k);

        for (int i = 0; i < nums.length; i++) {
            long x = nums[i];

            long inx = getInx(x, size);
            //由上述方法计算的桶坐标
            if (map.containsKey(inx)) {
                //当桶坐标存在，说明已经有此桶范围内的数，满足题意，
                // 差值绝对值 <= t，坐标差值为0，返回true
                return true;
            }
            long l = inx - 1;
            long r = inx + 1;
            //左右桶
            if (map.containsKey(l) && x - map.get(l) <= t) {
                //根据算法，左边数肯定小于右边数，因此调整减数与被减数，无需绝对值
                //左桶存在，说明在2t范围内 [0, 2t]可能有 [0,t]差值的数，于是相减判断，若有则返回
                //左桶只有一个数，否则多个数则满足 [0,t]直接返回

                return true;
            }
            if (map.containsKey(r) && map.get(r) - x <= t) {
                return true;
                //右桶同左桶
            }

            map.put(inx, x);

            if (i >= k) {
                //桶数量，因为，当 i 从0递增，当 i == k - 1时刚好k个桶，坐标差绝对值符合题意，大于等于则不符合题意，
                //需要将最左边，即数组坐标为i - k的数所在的桶移除
                map.remove(map.remove(getInx((long)nums[i - k], size)));
            }

        }
        return false;
        //遍历结束仍没有找到，返回false

    }

    private long getInx (long x, int size) {
        return x >= 0 ? x / size : (x + 1) / size - 1;
    }
}
