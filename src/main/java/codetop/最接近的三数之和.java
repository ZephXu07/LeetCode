package codetop;

import java.util.Arrays;

/**
 * Title: 最接近的三数之和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-15
 */
public class 最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        /*
            排序
            i + j + k
         */
        int len = nums.length - 2;
        /*
            至少三个数，
            i 的范围只能 i < len
         */
        int res = 100000;
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                /*
                    i 重复直接跳过
                 */
                continue;
            }
            int j = i + 1;
            /*
                j 的起始范围
             */
            int k = len + 1;
            /*
                k 的起始范围
             */
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                /*
                    三数之和
                 */
                if (sum == target) {
                    return target;
                    /*
                    没有比相等更接近的数
                     */
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    /*
                        如果更接近，替换
                     */
                    res = sum;
                }
                /*
                    因为 i < j < k
                    所以 sum < target 时
                    k 不能减小，sum更小，只能 j 增大
                    sum > target 时
                    j 不能增大，sum更大，只能 k 减小
                 */
                if (sum < target) {
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else {
                    k--;
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        最接近的三数之和 res = new 最接近的三数之和();
        System.out.println(res.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
