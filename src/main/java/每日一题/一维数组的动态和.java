package 每日一题;

/**
 * Title: 一维数组的动态和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-28
 */
public class 一维数组的动态和 {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}
