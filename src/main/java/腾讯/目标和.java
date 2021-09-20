package 腾讯;

/**
 * Title: 目标和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-11
 */
public class 目标和 {
    private int res;
    public int findTargetSumWaysBacktrack(int[] nums, int target) {
        res = 0;
        backtrack(nums, 0, target, 0);
        return res;
    }

    private void backtrack (int[] nums, int sum, int target, int start) {
        if (start == nums.length) {
            if (sum == target) {
                res ++;
            }
            return;
        }
        backtrack(nums, sum + nums[start], target, start + 1);
        backtrack(nums, sum - nums[start], target, start + 1);
    }


    public static void main(String[] args) {
        目标和 sum = new 目标和();
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(sum.findTargetSumWaysBacktrack(nums, target));
        System.out.println(sum.findTargetSumWaysDp(nums, target));
    }


    public int findTargetSumWaysDp(int[] nums, int target) {
        /*  正数和 x， 负数和 y， 数组和sum = x + y
                            目标target = x - y
                            则有 2x = sum + target
                            x = (sum + target) / 2
                            由于目标target 决不能大于 sum，大于则返回，
                            且其和不能为奇数，因为题目要求为非负整数
                            所以转化为求和为half的背包问题

            dp[j]代表的意义：填满容量为j的背包，有dp[j]种方法。因为填满容量为0的背包有且只有一种方法，所以dp[0] = 1

           先逆序遍历，是因为dp后面的和的情况是从前面的情况转移过来的

            dp[j] = dp[j] + dp[j - num]，
            当前填满容量为j的包的方法数 = 之前填满容量为j的包的方法数 + 之前填满容量为j - num的包的方法数
            也就是当前数num的加入，可以把之前和为j - num的方法数加入进来。

            返回dp[half]

         */

        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(target > sum || (target + sum) % 2 == 1) {
            return 0;
        }
        int half = (target + sum) / 2;
        int[] dp = new int[half + 1];
        dp[0] = 1;
        for(int num : nums){
            for(int j = half; j >= num; j--){
                dp[j] = dp[j] + dp[j - num];
                System.out.println(j + "---" + num);
            }
        }
        return dp[half];
    }
}
