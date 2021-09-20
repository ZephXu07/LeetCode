package codetop;

import java.util.Arrays;

/**
 * Title: 最大间距
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-02
 */
public class 最大间距 {
//    public int maximumGap(int[] nums) {
//        /*
//            基数排序，先按个位上大小排，再十位......直到数组中最大数的最大位数
//         */
//        int len = nums.length;
//        if (len < 2) {
//            /*
//                题目要求直接返回
//             */
//            return 0;
//        }
//
//        long exp = 1;
//        /*
//            值除 exp 即可省去几位数，取余则是某位上的值（个、十...）
//         */
//        int[] tmp = new int[len];
//        /*
//            暂存每次排序的复制
//         */
//        int max = Arrays.stream(nums).max().getAsInt();
//        /*
//            数组中最大值，减少遍历次数
//         */
//        while (max >= exp) {
//            int[] count = new int[10];
//            /*
//                统计某些位（个、十）上 1 - 9 的个数，再按 1 - 9 先暂存排序
//             */
//            for (int i = 0; i < len; i++) {
//                int inx = (nums[i] / (int)exp) % 10;
//                count[inx]++;
//            }
//
//            /*
//                计算前缀和，相当于计算 [1-9]上这些数在 tmp 中的下标
//                如 0 1 2 3 4 5
//                  1 2 3 4 5 6
//
//                          0 1 2 3 4 5 6 7 8 9
//                  count = 0 1 1 1 1 1 1 0 0 0
//                  计算之后 0 1 2 3 4 5 6 6 6 6
//                  举例 6 在 tmp 数组的下标会是 6
//             */
//            for (int i = 1; i < 10; i++) {
//                count[i] += count[i - 1];
//            }
//
//            for (int i = len - 1; i >= 0; i--) {
//                int inx = (nums[i] / (int)exp) % 10;
//                /*
//                    计算某位上的值（个、十...）
//                 */
//                tmp[count[inx] - 1] = nums[i];
//                /*
//                    填入辅助数组
//                 */
//                count[inx]--;
//                /*
//                    减一，也是为了计算下标
//                 */
//            }
//
//            System.arraycopy(tmp, 0, nums, 0, len);
//            /*
//                复制回去
//             */
//            exp *= 10;
//            /*
//                增大，获取更高位（十、百...）
//             */
//        }
//
//        int res = 0;
//        for (int i = 1; i < len; i++) {
//            res = Math.max(res, nums[i] - nums[i - 1]);
//        }
//
//        return res;
//    }


    public int maximumGap(int[] nums) {
        /*
            因为我们设置桶的大小代表的是间距的平均值，
            所以桶内两个元素的间距最大也就刚好为一个桶的大小,
            当然桶最小也是 1
            最大间距一定是大于等于平均间距的，
            （平均间距是每个都一样的情况，
            假如一个缩小了，那么必有一个扩大，
            此时他成为了最大间距）
            所以一定不可能出现在桶内，
            所以元素之间的最大间距一定不会出现在某个桶的内部，而一定会出现在不同桶当中。
         */

        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        int size = Math.min(1, (max - min) / (len - 1));
        /*
            设置桶的间距是平均间距
            于是 min + size 则是第二个桶的开始数量
            所以是一个左闭右开区间 [min, min + size) [min+size, min+2 * size)....
            所以总间距 / 桶间距 + 1 才是桶数量
         */
        int total = (max - min) / size + 1;

        int[][] bucket = new int[total][2];
        /*
            每个桶的最大值与最小值
            计算一个桶的最小值与前一个桶的最大值之差
            则是所求的最大间距
         */

        for (int i = 0; i < total; i++) {
            Arrays.fill(bucket[i], -1);
            /*
                存储 (桶内最小值，桶内最大值) 对，
                (-1, -1) 表示该桶是空的
             */
        }

        for (int i = 0; i < len; i++) {
            int inx = (nums[i] - min) / size;
            /*
                计算出数应该放在哪一个桶里
             */
            if (bucket[inx][0] == -1) {
                bucket[inx][0] = bucket[inx][1] = nums[i];
                /*
                    桶为空，最大最小都是第一个存放的数
                 */
            } else {
                bucket[inx][0] = Math.min(bucket[inx][0], nums[i]);
                bucket[inx][1] = Math.max(bucket[inx][1], nums[i]);
                /*
                    否则比较出最大值与最小值
                 */
            }
        }

        int res = 0;
        int pre = -1;

        for (int i = 0; i < len; i++) {
            if (bucket[i][0] == -1) {
                continue;
                /*
                    有的桶是空的，跳过
                 */
            }
            if (pre != -1) {
                res = Math.max(res, bucket[i][0] - bucket[pre][1]);
            }
            pre = i;
            /*
                pre 是记录当前遍历的桶的上一个不为空的桶
             */
        }

        return res;
    }
}
