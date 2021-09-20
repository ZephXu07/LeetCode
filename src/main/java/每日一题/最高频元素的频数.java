package 每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Title: 最高频元素的频数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-19
 */
public class 最高频元素的频数 {
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int right = 1;
        int left = 0;
        int res = 1;
        int len = nums.length;
        int sum = 0;
        while (right < len) {
            sum += (nums[right] - nums[right - 1]) * (right - left);
            /*
                0 1 2
                1 2 4
                当 right = 1,left = 0时
                    1 增加到 2 为 (1-0)*(2-1)=1
                    此时是初始状态，sum = 0,再加上 1 则是全部的
                当 right = 2,left = 0时
                    在前面的基础上 1 已经增加到 2 ，sum = 1
                此时即为 2 个 2 要增加到 4 ，即 (2-0)*(4-2)
                    sum = sum + 4 = 5
                即 sum = 5 是 1 和 2 增加到 4 的全部开销

                即有公式
                    sum += (right - left) * (nums[right] - nums[right - 1]

                 而当 sum > k 时不满足题意了，此时把最左边即选择增加的数中最小的剔除了，
                 则需要减去其开销，如 1 增加到了 4，开销是 3 ，sum - 3 = 2，即剩下的是 2 增加到 4 的开销

                 即有公式
                    sum -= nums[right] - nums[left]

                按照题目的要求使用滑动窗口即为最合适

             */

            while (sum > k) {
                sum -= nums[right] - nums[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;

        }
        return res;

    }


    public static void main(String[] args) {
//        int[] nums = {1,2,4};
//        int k = 5;
//        int[] nums = {1,4,8,13};
//        int k = 5;
//        int[] nums = {3,9,6};
//        int k = 2;
        int[] nums = {9940,9995,9944,9937,9941,9952,9907,9952,9987,9964,9940,9914,9941,9933,9912,9934,9980,9907,9980,9944,9910,9997};
        int k = 7925;
        System.out.println(maxFrequency(nums, k));
    }
}
