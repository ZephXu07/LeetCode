package codetop;

/**
 * Title: 打家劫舍2
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-09
 */
public class 打家劫舍2 {
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
        return Math.max(rob(nums, 0, nums.length - 2),
                rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int len = end - start + 1;
        if (len == 1) {
            return nums[start];
            /*
                长度为 1 自然是只有这家可以偷
             */
        }
        if (len == 2) {
            return Math.max(nums[start], nums[end]);
            /*
                长度为 2 就要考虑一下偷哪一家多的
             */
        }
//        int[] dp = new int[len];
        int dp;
        /*
            从 0 开始到 i 的房屋中偷哪些利益最大，当前这家 i 偷的话，i - 1 家不能偷
            dp[i - 1] + nums[i] = dp[i]
            当前这家不偷的话偷 i - 1 家
            dp[i - 1] = dp[i]
            两者取最大值
         */
        int pre = nums[start];
        int cur = Math.max(nums[start], nums[start + 1]);

        for (int i = 2 + start; i <= end; i++) {
            int tmp = cur;
            cur = Math.max(cur, pre + nums[i]);
            pre = tmp;

        }

        return cur;

    }

    public static void main(String[] args) {
        打家劫舍2 rob = new 打家劫舍2();
        System.out.println(rob.rob(new int[]{1, 2, 1, 1}) + "\t3");
        System.out.println(rob.rob(new int[]{1,7,9,2}) + "\t10");
    }
}
