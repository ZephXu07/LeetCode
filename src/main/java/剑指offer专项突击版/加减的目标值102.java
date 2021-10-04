package 剑指offer专项突击版;

/**
 * Title: 加减的目标值102
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-04
 */
public class 加减的目标值102 {

//    private int res;
//    public int findTargetSumWays(int[] nums, int target) {
//        res = 0;
//        backtrack(nums, 0, target, 0);
//        return res;
//    }
//
//    private void backtrack (int[] nums, int sum, int target, int start) {
//        if (start == nums.length) {
//            if (sum == target) {
//                res ++;
//            }
//            return;
//        }
//        backtrack(nums, sum + nums[start], target, start + 1);
//        backtrack(nums, sum - nums[start], target, start + 1);
//    }

//    public int findTargetSumWays(int[] nums, int target) {
//        /*
//            - 号的和，a
//            由于都是非负整数，a >= 0，数组的和 sum >= 0, - 号的和 (sum - a) >= 0
//            则 (sum - a) - a = target
//            sum - 2 * a = target
//            neg = (sum - target) / 2
//            neg >= 0，2a 需要为偶数
//            转换成 i 个数，选与不选，最后和为 neg
//
//
//         */
//        int sum = 0;
//        for (int n : nums) {
//            sum += n;
//        }
//        int diff = sum - target;
//        if (diff < 0 || (diff & 1) == 1) {
//            return 0;
//        }
//        int len = nums.length;
//        int neg = diff / 2;
//        int[][] dp = new int[len + 1][neg + 1];
//        /*
//            i   前 i 个数，从 1 开始数
//            j   数和为 j
//         */
//
//        dp[0][0] = 1;
//        /*
//            0 个数，和为 0 的方案只有一个
//                    和为其他数的方案不存在， 0
//         */
//        for (int i = 1; i <= len; i++) {
//            int n = nums[i - 1];
//            // 对每一个数进行选择与否
//            for (int j = 0; j <= neg; j++) {
//                dp[i][j] = dp[i - 1][j];
//                /*
//                    不选当前数时和已经为 j ，方案数等于前一个
//                 */
//
//                if (n <= j) {
//                    dp[i][j] += dp[i - 1][j - n];
//                    /*
//                        当前数小于 j 时才能选择，再加上不选 n 时的 i - 1 个数时和为 j - n的方案数
//                     */
//                }
//            }
//        }
//        return dp[len][neg];
//    }


    public int findTargetSumWays(int[] nums, int target) {
        /*
            - 号的和，a
            由于都是非负整数，a >= 0，数组的和 sum >= 0, - 号的和 (sum - a) >= 0
            则 (sum - a) - a = target
            sum - 2 * a = target
            neg = (sum - target) / 2
            neg >= 0，2a 需要为偶数
            转换成 i 个数，选与不选，最后和为 neg


         */
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int diff = sum - target;
        if (diff < 0 || (diff & 1) == 1) {
            return 0;
        }
        int len = nums.length;
        int neg = diff / 2;
        int[][] dp = new int[2][neg + 1];
        /*
            i   前 i 个数，从 1 开始数
            j   数和为 j
         */

        dp[0][0] = 1;
        /*
            0 个数，和为 0 的方案只有一个
                    和为其他数的方案不存在， 0
         */
        for (int i = 1; i <= len; i++) {
            int n = nums[i - 1];
            // 对每一个数进行选择与否
            for (int j = 0; j <= neg; j++) {
                dp[i & 1][j] = dp[(i - 1) & 1 ][j];
                /*
                    不选当前数时和已经为 j ，方案数等于前一个
                 */

                if (n <= j) {
                    dp[i & 1][j] += dp[(i - 1) & 1 ][j - n];
                    /*
                        当前数小于 j 时才能选择，再加上不选 n 时的 i - 1 个数时和为 j - n的方案数
                     */
                }
            }
        }
        return dp[len & 1][neg];
    }

}
