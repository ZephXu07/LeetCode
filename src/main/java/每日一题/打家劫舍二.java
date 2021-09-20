package 每日一题;

/**
 * Title: 打家劫舍二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-15
 */
public class 打家劫舍二 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            return Math.max(rob(nums, 0, len - 1),
                    rob(nums, 1, len));
        }
        /*同打家劫舍一，要进行选择，挑第一个或者最后一个，或者都不，但都不的情况少于等于前俩种，省略*/
    }

    private int rob(int[] nums, int start, int end) {
        // 记录 dp[i+1] 和 dp[i+2]
        int dpI1 = 0, dpI2 = 0;
        // 记录 dp[i]
        int dpI = 0;
        for (int i = end - 1; i >= start; i--) {
            dpI = Math.max(dpI1, nums[i] + dpI2);
            dpI2 = dpI1;
            dpI1 = dpI;
        }
        return dpI;
    }
}
