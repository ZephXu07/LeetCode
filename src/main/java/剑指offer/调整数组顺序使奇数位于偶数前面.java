package 剑指offer;

import java.util.Arrays;

/**
 * Title: 调整数组顺序使奇数位于偶数前面
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-30
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high && low != high - 1) {
            while (low < high && nums[low] % 2 == 1) {
                low ++;
            }
            while (high > low && nums[high] % 2 == 0) {
                high --;
            }
            if (low == high) {
                break;
            }
            swap(nums, low, high);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        调整数组顺序使奇数位于偶数前面 res = new 调整数组顺序使奇数位于偶数前面();
        System.out.println(Arrays.toString(res.exchange(nums)));
    }
}
