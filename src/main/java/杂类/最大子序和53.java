package 杂类;

/**
 * Title: 最大子序和53
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-28
 */
public class 最大子序和53 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int cur = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], pre + nums[i]);
            pre = cur;
            res = Math.max(res, cur);
        }
        return res;
    }
}
