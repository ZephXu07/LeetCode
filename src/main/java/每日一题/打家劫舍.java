package 每日一题;

import java.util.Arrays;

/**
 * Title: 打家劫舍
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-15
 */
public class 打家劫舍 {
    public int robDp(int[] nums) {
        int len = nums.length;
        // dp[i] = x 表示：
        // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
        // base case: dp[len] = 0
        int[] dp = new int[len + 2];
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
            //从倒数开始计算，因为后两个是不存在的，故为0
            //只能选一个跳一个，当选择了当前的，只能从接下来第二个选，因此加上接下来第二个开始抢最大的数量
        }
        return dp[0];
        //按题目要求返回从0开始挑选的
    }


    private int[] memo;
    // 主函数
    public int robRecursive(int[] nums) {
        // 初始化备忘录
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        // 强盗从第 0 间房子开始抢劫
        return dp(nums, 0);
    }

    // 返回 dp[start..] 能抢到的最大值
    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        // 避免重复计算
        if (memo[start] != -1){
            return memo[start];
        }

        int res = Math.max(dp(nums, start + 1),
                nums[start] + dp(nums, start + 2));
        // 记入备忘录
        memo[start] = res;
        return res;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        // 记录 dp[i+1] 和 dp[i+2]
        int dpI1 = 0, dpI2 = 0;
        // 记录 dp[i]
        int dpI = 0;
        for (int i = n - 1; i >= 0; i--) {
            dpI = Math.max(dpI1, nums[i] + dpI2);
            dpI2 = dpI1;
            dpI1 = dpI;
        }
        return dpI;
    }
}
