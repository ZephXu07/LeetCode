package codetop;

import java.util.*;

/**
 * Title: 最小区间
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-20
 */

public class 最小区间 {
//    public int[] smallestRange(List<List<Integer>> nums) {
//        int left = -100001;
//        int right = 100001;
//        int range = 200002;
//        /*
//            根据题目的条件初始化
//            max 是右边界，此刻初始化为左边界
//         */
//        int max = left;
//
//        int len = nums.size();
//        int[] index = new int[len];
//        /*
//            每个区间的当前指针下标
//         */
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
//                Comparator.comparingInt(i -> nums.get(i).get(index[i])));
//        /*
//            小顶堆
//            根据代表的区间的当前指针下标指到的值的大小排序
//         */
//
//        for (int i = 0; i < len; i++) {
//            minHeap.offer(i);
//            max = Math.max(max, nums.get(i).get(0));
//            /*
//                添加进小顶堆
//                同时初始哈每个区间列表第一个值的最大值
//             */
//        }
//
//        while (true) {
//            int minInx = minHeap.poll();
//            /*
//                弹出所有区间中当前指针最小的值的区间号
//             */
//            int curRange = max - nums.get(minInx).get(index[minInx]);
//            /*
//                因为在前面初始哈了 max了，在第一次运行到这时
//                是所有区间的第一个值的最大值，与最小值比较
//                则得到了区间范围
//
//                后面会依次更新现有的区间最大值，再与当前的区间最小值再比较
//             */
//
//            if (curRange < range) {
//                /*
//                    比现有的区间还小，更新区间范围及左右边界
//                 */
//                range = curRange;
//                left = nums.get(minInx).get(index[minInx]);
//                right = max;
//            }
//
//            index[minInx]++;
//            /*
//                当前的区间的值在所有区间推举的数中最小，
//                因此指向当前区间的下一个更大的值
//             */
//            if (index[minInx] == nums.get(minInx).size()) {
//                /*
//                    遍历完一个区间的所有值
//                    即接下来寻找的最小区间的范围不包括当前值了
//                    于是结束循环，找到了最小区间
//                 */
//                break;
//            }
//            minHeap.offer(minInx);
//            /*
//                加入小顶堆中重新排序
//             */
//            max = Math.max(max,nums.get(minInx).get(index[minInx]));
//            /*
//                更新了一共区间的推举值，
//                得到其值与上一轮的最大值比较
//                得出更大的值
//             */
//        }
//        return new int[]{left, right};
//    }


    public int[] smallestRange(List<List<Integer>> nums) {
        /*
            将各个区间的值映射到一个对应链表，
            存储区间的编号，
            滑动窗口遍历所有的值，再统计值对应的区间的次数，
            即次数等于 1 时有效值增加，
            当有效值为区间数量则判断滑动窗口的大小与当前已经计算的大小比较，
            则缩小左边界，直到有效值小于区间值，再重新扩大右边界
            不断重复直到遍历到区间的最大值
         */
        int len = nums.size();
        Map<Integer, List<Integer>> valueToGroup = new HashMap<>();
        int min = 100001;
        int max = -100001;
        int bestRange = 200002;
        for (int i = 0; i < len; i++) {
            for (int n : nums.get(i)) {
                List<Integer> list = valueToGroup.getOrDefault(n, new LinkedList<>());
                list.add(i);
                valueToGroup.put(n, list);
                min = Math.min(min, n);
                max = Math.max(max, n);
            }
        }
        /*
            值与对应区间的链表的哈希表
            计算滑动窗口即将遍历的值的范围
         */
        int bestLeft = min;
        int bestRight = max;

        int left = min;
        int right = min;
        int[] freq = new int[len];
        /*
            统计区间的次数
         */
        int valid = 0;
        /*
            有效区间的值
         */
        while (right <= max) {
            if (!valueToGroup.containsKey(right)) {
                /*
                    当此值没出现在所有区间中，跳过
                 */
                right++;
                continue;
            }
            List<Integer> groups = valueToGroup.get(right);
            for (int g : groups) {
                freq[g]++;
                if (freq[g] == 1) {
                    valid++;
                }
            }
            /*
                更新右边界对应的区间的次数，及有效值
             */
            while (valid == len) {
                /*
                    有效值等于所有区间数
                    计算最佳结果
                    缩减左边界
                    左边界的值如果存在于任何一个区间里则跳过
                    否则则更新区间次数及有效区间值
                 */
                if (right - left < bestRange) {
                    bestRange = right - left;
                    bestLeft = left;
                    bestRight = right;
                }
                if (valueToGroup.containsKey(left)) {
                    groups = valueToGroup.get(left);
                    for (int g : groups) {
                        freq[g]--;
                        if (freq[g] == 0) {
                            valid--;
                        }
                    }
                }
                left++;
            }
            right++;
        }
        return new int[]{bestLeft, bestRight};
    }


    public static void main(String[] args) {
        最小区间 res = new 最小区间();
        List<List<Integer>> nums = new LinkedList<>();
        nums.add(Arrays.asList(4,10,15,24,26));
        nums.add(Arrays.asList(0,9,12,20));
        nums.add(Arrays.asList(5,18,22,30));
        System.out.println(Arrays.toString(res.smallestRange(nums)));

    }
}
