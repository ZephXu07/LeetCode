package codetop;

/**
 * Title: 打家劫舍
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-09
 */
public class 打家劫舍 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
            /*
                长度为 1 自然是只有这家可以偷
             */
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
            /*
                长度为 2 就要考虑一下偷哪一家多的
             */
        }
        int[] dp = new int[len];
        /*
            从 0 开始到 i 的房屋中偷哪些利益最大，当前这家 i 偷的话，i - 1 家不能偷
            dp[i - 1] + nums[i] = dp[i]
            当前这家不偷的话偷 i - 1 家
            dp[i - 1] = dp[i]
            两者取最大值
         */
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[len - 1];

    }

    public int rob1(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
            /*
                长度为 1 自然是只有这家可以偷
             */
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
            /*
                长度为 2 就要考虑一下偷哪一家多的
             */
        }
//        int[] dp = new int[len];
        int[] dp = new int[3];
        /*
            从 0 开始到 i 的房屋中偷哪些利益最大，当前这家 i 偷的话，i - 1 家不能偷
            dp[i - 1] + nums[i] = dp[i]
            当前这家不偷的话偷 i - 1 家
            dp[i - 1] = dp[i]
            两者取最大值
         */
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i % 3] = Math.max(dp[(i - 1) % 3], dp[(i - 2) % 3] + nums[i]);
        }

        return dp[(len - 1) % 3];

    }

    public static void main(String[] args) {
        打家劫舍 rob = new 打家劫舍();
        System.out.println(rob.rob1(new int[]{1,7,9}));
        System.out.println(rob.rob1(new int[]{7,9,2}));
    }

}
