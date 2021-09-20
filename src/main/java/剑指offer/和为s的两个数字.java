package 剑指offer;

import java.util.Arrays;

/**
 * Title: 和为s的两个数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-05
 */
public class 和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        int low = 0;
        int high = len - 1;
        while (low < high) {
            sum = nums[low] + nums[high];
            if (sum < target) {
                low ++;
            } else if (sum > target) {
                high --;
            } else {
                return new int[]{nums[low], nums[high]};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        和为s的两个数字 res = new 和为s的两个数字();
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(res.twoSum(nums, target)));
    }
}
