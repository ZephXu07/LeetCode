package 每日一题;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Title: 组合总和IV
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-24
 */
public class 组合总和IV {
    /* 回溯超时 */
//    private int res;
//    public int combinationSum4(int[] nums, int target) {
//        Arrays.sort(nums);
//        res = 0;
//        LinkedList<Integer> track = new LinkedList<>();
//        backtrack(track, nums, target, 0);
//        return res;
//    }
//
//    private void backtrack (LinkedList<Integer> track, int[] nums, int target, int sum) {
//        if (sum == target) {
//            res++;
//            return;
//        }
//        if (sum > target) {
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (sum + nums[i] <= target) {
//                track.add(nums[i]);
//                backtrack(track, nums, target, sum + nums[i]);
//                track.removeLast();
//            }
//        }
//
//
//
//    }


    public int combinationSum4(int[] nums, int target) {
        // 0 到 target的所有方案总数

        int[] dp = new int[target + 1];

        dp[0] = 1;
        //和为0的方案只有一种，什么都不要

        for (int i = 1; i <= target; i++) {
            //遍历 1 -- > target

            for (int n : nums) {
                //遍历数组
                if (n <= i) {
                    //当 n <=  i时，说明可以由 n -- > i， 立即把 n 添加，而剩下的 i - n 的种类由前面推出
                    dp[i] += dp[i - n];
                }
            }
        }

        return dp[target];

    }

    public static void main(String[] args) {
        组合总和IV res = new 组合总和IV();
        int[] nums = {1,2,3};
        int target = 4;

        System.out.println(res.combinationSum4(nums, target) + "\t7");
        int[] nums1 = {9};
        int target1 = 3;
        System.out.println(res.combinationSum4(nums1, target1) + "\t0");

    }


}
