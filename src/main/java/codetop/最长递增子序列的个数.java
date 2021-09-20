package codetop;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: 最长递增子序列的个数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-26
 */
public class 最长递增子序列的个数 {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        int[] dp = new int[len];
        /*
            以 nums[i] 结尾的最长上升子序列的最长长度
         */
        int[] count = new int[len];
        /*
            以 nums[i] 结尾的最长上升子序列的个数
         */
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            count[i] = 1;
            /*
                单就 nums[i] 结尾的最长上升子序列长度为 1
                当然就自身而言个数也为 1
             */
        }
        int max = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    /*
                        此处仍是最长上升子序列的解法
                     */
                    if (dp[i] == dp[j] + 1) {
                        /*
                            nums[j]结尾的最长上升子序列 加上 nums[i] 构成新的最长上升子序列
                            长度相等
                            此时以nums[j]结尾的子序列个数，应该计算到
                            以nums[i] 结尾的最长上升子序列的个数中
                            因为其最长长度相等，结尾也是 nums[i]
                            符合 count[i] 的定义
                         */
                        count[i] += count[j];
                    } else if (dp[i] < dp[j] + 1) {
                        /*
                            nums[j]结尾的最长上升子序列 加上 nums[i] 构成新的最长上升子序列
                            大于之前原有的 以nums[i] 构成的最长上升子序列的长度
                            根据 dp[i] 以 nums[i] 结尾的最长上升子序列的最长长度
                            更新值，所以 count[i] 也相应更新为 count[j] 的值
                            即以nums[i] 结尾的最长上升子序列的个数会等于
                            以nums[j] 结尾的最长上升子序列的个数
                         */
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    /*
                        else
                        即 nums[j]结尾的最长上升子序列 加上 nums[i] 构成新的最长上升子序列
                        小于之前原有的 以nums[i] 构成的最长上升子序列的长度
                        根据 dp[i]
                        count[i] 的定义，我们不需要更新
                     */
                }
            }
            max = Math.max(max, dp[i]);
            /*
                更新最大
             */
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == max) {
                res += count[i];
                /*
                    计算
                 */
            }
        }
        return res;
    }

    public static void main(String[] args) {
        最长递增子序列的个数 res = new 最长递增子序列的个数();
        System.out.println(res.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
    }
}
