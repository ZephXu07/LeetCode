package 剑指offer;

/**
 * Title: 连续子数组的最大和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-01
 */
public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int len = nums.length;
//        int[] dp = new int[len];
//        dp[0] = nums[0];
        int dpOld = nums[0];
        int dpNew;
        int res = nums[0];
        for (int i = 1; i < len; i++) {
//            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            dpNew = Math.max(nums[i], nums[i] + dpOld);
            dpOld = dpNew;
            res = Math.max(res, dpNew);
        }
        return res;
    }
}
