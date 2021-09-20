package 每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Title: 存在重复元素3
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-17
 */
public class 存在重复元素3 {
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        /* 题目abs(nums[i] - nums[j]) <= t
        转化不等式为 nums[i] + t >= nums[j] && nums[i] - t <= nums[j]

        因为TreeSet（Map没有因此放弃）提供的ceiling方法返回的是大于等于的，又因为使用滑动窗口，所以需要进行转化

        同时 abs (i - j) <= k，即滑动窗口的宽度为 k，TreeSet的长度为k最大，大于k 时移除最左边，坐标为 i - k
         */

        int len = nums.length;
        // 特判
        if (len == 0 || k <= 0 || t < 0) {
            return false;
        }


        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            Long ceil = set.ceiling((long)nums[i] - t);
            //可能不存在

            if (null != ceil && ceil <= (long)nums[i] + t) {
                return true;
            }

            set.add((long)nums[i]);
            //添加到窗口
            if (set.size() > k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        /*  abs(nums[i] - nums[j]) <= t，假设t = 2，则差的绝对值可以是0，1，2


            因此坐标计算 inx， 当 x >= 0 ： x / (t + 1)
                            当 x < 0：( x + 1 ) / (t + 1) - 1
            为了把某（t + 1）个数正确映射到某个容量范围的桶
            如 0， 1， 2，除以容量3，得到 0
            而 -1， -2， -3 除以3则有-1和0，出现错误，因此，
            把负数统一加一得到 0，-1，-2， 此时除以3是0，也出错，但若再减一则是-1，正确

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
                return true;
            }
            if (map.containsKey(r) && map.get(r) - x <= t) {
                return true;
                //右桶桶左桶
            }

            map.put(inx, x);

            if (i >= k) {
                //桶数量，因为 i 从0递增，当 i == k - 1时刚好k个桶，坐标差绝对值符合题意，大于等于则不符合题意，
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
