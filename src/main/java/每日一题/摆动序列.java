package 每日一题;

/**
 * Title: 摆动序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-12
 */
public class 摆动序列 {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (0 == len || 1 == len) {
            return len;
        }
        if (2 == len) {
            return nums[1] - nums[0] == 0 ? 1 : 2;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        int j = 1;
        while (j < len && nums[j] - nums[j - 1] == 0) {
            dp[j] = 1;
            j++;
        }
        boolean flag = true;
        if (j < len) {
            dp[j] = 2;
            flag = nums[j] - nums[j - 1] > 0;
        }
        
        for (int i = j + 1; i < len; i++) {
            if (flag) {
                if (nums[i] - nums[i - 1] >= 0) {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = Math.max(dp[i - 1], dp[i - 1] + 1);
                    flag = false;
                }
            } else {
                if (nums[i] - nums[i - 1] > 0) {
                    dp[i] = Math.max(dp[i - 1], dp[i - 1] + 1);
                    flag = true;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[len - 1];
    }

    public int wiggleMaxLengthOptimized(int[] nums) {
        int len = nums.length;
        if (0 == len || 1 == len) {
            return len;
        }
        if (2 == len) {
            return nums[1] - nums[0] == 0 ? 1 : 2;
        }
        int dp = 1;
        int j = 1;
        while (j < len && nums[j] - nums[j - 1] == 0) {
            j++;
        }
        boolean flag = true;
        if (j < len) {
            dp = 2;
            flag = nums[j] - nums[j - 1] > 0;
        }

        for (int i = j + 1; i < len; i++) {
            if (flag && nums[i] - nums[i - 1] <= 0) {
                dp = Math.max(dp, dp + 1);
                flag = false;
            } else if (!flag && nums[i] - nums[i - 1] > 0) {
                dp = Math.max(dp, dp + 1);
                flag = true;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        摆动序列 res = new 摆动序列();
//        int[] nums = {1,7,4,9,2,5};
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
//        int[] nums = {3,3,3,2,5};
//        int[] nums = {3,3,3};
        System.out.println(res.wiggleMaxLength(nums));
        System.out.println(res.wiggleMaxLengthOptimized(nums));
    }
}
