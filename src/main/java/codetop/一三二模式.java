package codetop;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * Title: 一三二模式
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-05
 */
public class 一三二模式 {
//     public boolean find132pattern(int[] nums) {
//         int len = nums.length;
//         if (len < 3) {
//             return false;
//         }
//         Deque<Integer> stack = new LinkedList<>();
//         stack.push(nums[len - 1]);
//         /*
//            单调栈，栈顶到栈底单调递增，从右往左遍历
//          */
//         Integer max2 = Integer.MIN_VALUE;
//         /*
//            132 的 2 ，所以设为 max2
//          */
//         for (int i = len - 2; i >= 0; i--) {
//             if (nums[i] < max2) {
//                 /*
//                    max2 是小于单调栈里的3的 2 ，
//                    所以此处是找到了 1
//                    由于 max2 的初始值赋值，
//                    所以此处 max2 是重新赋值的，
//                    于是自然栈里有 3
//                    直接返回
//                  */
//                 return true;
//             }
//             while (!stack.isEmpty() && nums[i] > stack.peek()) {
//                 /*
//                    把栈中小于当前遍历的元素的值全部弹出
//                    即 2 弹出，最后一个弹出的 2 是最大的 2
//                  */
//                 max2 = stack.pop();
//             }
//             stack.push(nums[i]);
//             /*
//                压入 3
//              */
//         }
//         return false;
//     }

//    public boolean find132pattern(int[] nums) {
//        /*
//            mapRight  TreeMap 存储 [2,len-1]的值
//            枚举左边 left 与 当前遍历的值 nums[i]
//            在 mapRight 中找到严格大于 left 的数
//            如果存在，与 当前的 nums[i] 比较，小于则找到了 132 结束
//            否则则继续 left 与 nums[i] 找更小的
//            同时在 mapRight 中更新即将要遍历的 nums[i + 1] 的次数
//         */
//        int len = nums.length;
//        if (len < 3) {
//            return false;
//        }
//        TreeMap<Integer, Integer> rightAll = new TreeMap<>();
//        for (int i = 2; i < len; i++) {
//            rightAll.put(nums[i], rightAll.getOrDefault(nums[i], 0) + 1);
//        }
//        int left = nums[0];
//        for (int i = 1; i < len - 1; i++) {
//            if (left < nums[i]) {
//                Integer right = rightAll.ceilingKey(left + 1);
//                if (null != right && right < nums[i]) {
//                    return true;
//                }
//            }
//            left = Math.min(left, nums[i]);
//            int count = rightAll.get(nums[i + 1]);
//            rightAll.put(nums[i + 1], --count);
//            if (count == 0) {
//                rightAll.remove(nums[i + 1]);
//            }
//        }
//        return false;
//    }


    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        /*
            单调栈，栈底 --> 栈顶， 大 --> 小
         */
        LinkedList<Integer> list = new LinkedList<>();
        /*
            当前遍历的元素是 nums[i]，
            数组对应的下标 i 存放的值是 [0,i-1] 的最小值
            当 i == 0时，不符合 132 的情况
            所以此时 list.size == 0
         */
        list.addLast(Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                /*
                    栈存放的是数组中值的下标，
                    单调栈，存放的下标的元素从栈底到栈顶单调递减
                 */
                stack.pop();
            }
            if (!stack.isEmpty() && list.get(stack.peek()) < nums[i]) {
                /*
                    单调栈中还有比 nums[i] 更大的元素
                    即 [0,i-1] 有比 nums[i] 更大的元素
                    即 3 > 2
                    stack.peek() 是这个元素在 nums[] 的下标
                    而 list存放的是 nums[i] 其左侧的最小值
                    于是 list[stack.peek()]代表是单调栈中
                    存在的元素的左侧的最小值，如果它小于 nums[i]
                    则满足了 1 < 2

                    则是 1 < 3 > 2
                 */
                return true;
            }
            stack.push(i);
            if (i == 0) {
                list.addLast(nums[i]);
                /*
                    i == 0 时左侧没有元素，直接添加
                    即 nums[0] 是 [0] 最小元素
                 */
            } else {
                list.addLast(Math.min(list.getLast(), nums[i]));
                /*
                    更新 [0,i] 最小的元素
                 */
            }
        }
        return false;
    }

    public static void main(String[] args) {
        一三二模式 res = new 一三二模式();
//        System.out.println(res.find132pattern(new int[]{3,1,4,2}));
        System.out.println(res.find132pattern(new int[]{-1,3,2,0}));
    }

}
