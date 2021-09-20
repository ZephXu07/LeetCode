package 腾讯;

/**
 * Title: 分割等和子集
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-11
 */
public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if ((sum & 1) == 1) {
            //奇数，不能等和，直接返回
            return false;
        }
        int target = sum / 2;
        //求容量
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        //容量为0时一种分割方案
        for (int i : nums) {
            for (int j = target; j >= i ; j--) {
                //
                dp[j] = dp[j] || dp[j - i];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        分割等和子集 res = new 分割等和子集();
        int[] nums = {1,5,11,5};
        System.out.println(res.canPartition(nums));
    }
}
