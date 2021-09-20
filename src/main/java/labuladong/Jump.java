package labuladong;

import java.util.Arrays;

/**
 * Title: labuladong.Jump
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-17
 */
public class Jump {
    private int[] nums;
    private int[] memo;
    public int jump(int[] nums) {
        this.nums = nums;
        memo = new int[nums.length];
        Arrays.fill(memo, nums.length);
        return dp(0);
    }
    private int dp(int p) {
        int length = nums.length;
        if (p >= length - 1) {
            return 0;
        }
        if (memo[p] != length) {
            return memo[p];
        }
        for (int i = 1; i <= nums[p]; i++) {
            memo[p] = Math.min(memo[p], dp(p + i) + 1);
        }
        return memo[p];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Jump jump = new Jump();
        int jump1 = jump.jump(nums);
        System.out.println(jump1);
    }
}
