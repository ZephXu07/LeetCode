package codetop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: 戳气球
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-01
 */
public class 戳气球 {

//    private int[] nums;
//    private int[][] memo;
//    public int maxCoins(int[] nums) {
//        int len = nums.length;
//        this.nums = new int[len + 2];
//        this.nums[0] = 1;
//        this.nums[len + 1] = 1;
//        System.arraycopy(nums, 0, this.nums, 1, len);
//        /*
//            新建 nums 数组，最左和最右填充 1
//         */
//        memo = new int[len + 2][len + 2];
//        for (int i = 0; i < memo.length; i++) {
//            Arrays.fill(memo[i], -1);
//            /*
//                初始化
//             */
//        }
//
//        return dfs(0, memo.length - 1);
//
//
//    }
//
//    private int dfs (int left, int right) {
//        if (left >= right - 1) {
//            /*
//                因为前后加了个 1
//                所以等 l == 0, r == 1 时已经到边界了，
//                还有 len 为原数组长度，此时 r = len + 1，当 l = len 即 r - 1 时已经溢出了
//
//             */
//            return 0;
//        }
//
//        if (memo[left][right] != -1) {
//            /*
//                初始化为 -1
//                如果不为 -1 表示计算过 (left, right)开区间 内填满气球所能获得的最大硬币数
//             */
//            return memo[left][right];
//        }
//        int res = memo[left][right];
//        for (int i = left + 1; i < right; i++) {
//            /*
//                填了当前位置 i
//                还需要填 (left,i)开区间 和 (i,right) 区间
//             */
//            int sum = nums[left] * nums[i] * nums[right];
//            /*
//                填了此气球获得的硬币数
//             */
//            sum += dfs(left, i) + dfs(i, right);
//            /*
//                找到填满此区间(left,right) 的顺序使获得硬币最大化
//             */
//            res = Math.max(sum, res);
//        }
//        memo[left][right] = res;
//        /*
//            记录，返回
//         */
//        return res;
//    }

    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] tmp = new int[len + 2];
        tmp[0] = 1;
        tmp[len + 1] = 1;
        for (int i = 0; i < len; i++) {
            tmp[i + 1] = nums[i];
        }
        /*
            新建 nums 数组，最左和最右填充 1
         */

        int[][] dp = new int[len + 2][len + 2];
        /*
            (i,j)开区间填充气球得到的硬币的最大值
         */

        for (int i = len - 1; i >= 0; i--) {
            /*
                逆序是因为 (i,k) 还没计算
                因为数组加了两个虚拟值，
                所以 i = len - 1 ，保证
                一开始至少是 (len - 1, len + 1)
                len下标的数刚好是原数组的 nums[len - 1]
                到达 0是最后一圈遍历
             */
            for (int j = i + 2; j <= len + 1; j++) {
                /*
                    同理 j = i + 2 是保证(i,j)之间至少一个数
                    到达 len + 1 是最后一圈遍历
                 */
                for (int k = i + 1; k < j; k++) {
                    /*
                        枚举 (i,j) 之间
                     */
                    int sum = dp[i][k] + tmp[i] * tmp[k] * tmp[j] + dp[k][j];
                    /*
                        填充了 k 位置气球，还有 (i,k) 和 (k,j) 气球没填充
                     */
                    dp[i][j] = Math.max(dp[i][j], sum);
                    /*
                        取 (i,j) 气球中最大的
                     */
                }
            }
        }

        return dp[0][len + 1];


    }

    public static void main(String[] args) {
        戳气球 res = new 戳气球();
        System.out.println(res.maxCoins(new int[]{3, 1, 5, 8}));
        System.out.println(res.maxCoins(new int[]{1, 5}));
    }
}
