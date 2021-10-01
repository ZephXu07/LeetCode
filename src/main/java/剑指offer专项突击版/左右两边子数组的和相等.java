package 剑指offer专项突击版;

/**
 * Title: 左右两边子数组的和相等
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-01
 */
public class 左右两边子数组的和相等 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int num : nums) {
            sum += num;
        }
        int pre = 0;
        for (int i = 0; i < len; i++) {
            if (2 * pre + nums[i] == sum) {
                return i;
            }
            pre += nums[i];
        }
        return -1;
    }
}
