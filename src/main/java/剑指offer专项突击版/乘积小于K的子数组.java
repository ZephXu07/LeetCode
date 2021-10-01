package 剑指offer专项突击版;

/**
 * Title: 乘积小于K的子数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-01
 */
public class 乘积小于K的子数组 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int res = 0;
        int len = nums.length;

        int left = 0;
        int right = 0;

        int prod = 1;

        while (right < len) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            res += (right - left) + 1;
            /*
                以 nums[right] 结尾的连续数组有多少个
                [l,r]
                举例 [5,2,6]
                [5,2,6]
                [2,6]
                [6]

             */
            right++;
        }
        return res;

    }
}
