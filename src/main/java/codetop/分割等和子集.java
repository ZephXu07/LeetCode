package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 分割等和子集
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-01
 */
public class 分割等和子集 {
//    private Map<String, Boolean> map;
//    public boolean canPartition(int[] nums) {
//        int len = nums.length;
//        int sum = 0;
//        int max = 0;
//        for (int n : nums) {
//            sum += n;
//            max = Math.max(max, n);
//        }
//
//        if ((sum & 1) == 1) {
//            /*
//                数组和为奇数的话无法等分
//             */
//            return false;
//        }
//
//        if (max > sum / 2) {
//            /*
//                数组中存在比数组和的一半还大的数
//                即剩下的数的和无法等于数组和的一半
//                直接返回
//             */
//            return false;
//        }
//
//        map = new HashMap<>();
//        return dfs(nums, 0, 0, sum / 2, len);
//
//    }
//
//    private boolean dfs (int[] nums, int sum, int inx, int target, int len) {
//        if (sum == target) {
//            /*
//                找到了和等于数组和的一半
//             */
//            return true;
//        }
//
//        if (sum > target || inx == len ) {
//            /*
//                和大于数组和的一半，或者遍历完数组，结束
//             */
//            return false;
//        }
//
//        String key = sum + "_" + inx;
//        if (map.containsKey(key)) {
//            /*
//                [0,inx - 1]已经遍历过，和为 sum
//                此时 map 中已经存在 [inx, len-1]的遍历结果
//                直接返回
//             */
//            return map.get(key);
//        }
//
//        boolean res = dfs(nums, sum + nums[inx], inx + 1, target, len)
//                || dfs(nums, sum, inx + 1, target, len);
//                /*
//                    选与不选
//                 */
//        map.put(key, res);
//
//        return res;
//    }


    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int max = 0;
        for (int n : nums) {
            sum += n;
            max = Math.max(max, n);
        }

        if ((sum & 1) == 1) {
            /*
                数组和为奇数的话无法等分
             */
            return false;
        }

        int target = sum / 2;
        if (max > target) {
            /*
                数组中存在比数组和的一半还大的数
                即剩下的数的和无法等于数组和的一半
                直接返回
             */
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        /*
            [0,i] 的数选择部分的和为 target 是否有可能

            初始化 当什么都不选时和为 0，即 dp[0, len - 1][0] = true

            当只有一个数 [0] 可选且和为 nums[0] 也可能，dp[0][nums[0] = true

            当 j >= nums[i] 时，可选与不选
            选：dp[i][j] = dp[i - 1][j - nums[i]]
            不选：dp[i][j] = dp[i - 1][j]
            总 dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j]

            发现可以使用一维，在遍历时 j 从 target 开始，避免覆盖上一轮的 i - 1
         */


        dp[0] = true;

        dp[nums[0]] = true;

        for (int i = 1; i < len; i++) {
            for (int j = target; j > 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }

        return dp[target];
    }
}
