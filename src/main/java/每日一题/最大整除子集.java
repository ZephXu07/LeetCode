package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 最大整除子集
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-23
 */
public class 最大整除子集 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //排序
        Arrays.sort(nums);
        int len = nums.length;

        int[] dp = new int[len];

        int maxSize = 1;
        //子集最大长度
        int maxVal = dp[0];
        //子集最大值

        /* https://leetcode-cn.com/problems/longest-increasing-subsequence/
            转化为最长上升子序列的dp解法

            a % b == 0, a = x * b
            b % c == 0, b = y * c
            则有 a % c == 0, a = x * y * c



         */
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            //在此初始化减少一次遍历填充1
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    //可以整除
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    //比较子集长度
                }
            }

            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
                //找到最大子集的长度及子集最大值

            }

        }

        List<Integer> res = new LinkedList<>();

        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
            //长度为1时随意填充即可返回
        }

        //题目似乎没要求子集要按递增顺序
        for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
            //从后往前遍历
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                //等于最大长度，且可以取余为0
                res.add(nums[i]);
                maxSize --;
//                maxVal = nums[i];
                //更新条件
            }
        }

        return res;

    }
}
