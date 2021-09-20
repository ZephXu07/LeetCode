package 每日一题;

/**
 * Title: 删除并获得点数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-05
 */
public class 删除并获得点数 {
    public int deleteAndEarn(int[] nums) {
        /*
            转化为打家劫舍问题，抢了一家，隔壁左右的均不能再抢
            题目是获得这个数后隔壁两个数都删去了，只要出现一次就删去左右全部
            新数组中的元素count[i]代表着数值为 i 的数在 nums数组出现的次数

            max是nums数组最大值，方便创建元素，+ 1是因为当下标为 max时长度为 max + 1

            dp数组长度 max + 3是因为count数组长度为 max + 1
            而状态转移是 dp[i] = Math.max(dp[i + 1], count[i] * i + dp[i + 2])
            从后往前遍历，从max开始遍历
         */

        if (null == nums || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int max = nums[0];
        for (int i : nums) {
            max = Math.max(i, max);
        }
        int[] count = new int[max + 1];
        for (int i : nums) {
            count[i]++;
        }
        int[] dp = new int[max + 3];

        for (int i = max; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], count[i] * i + dp[i + 2]);
        }

        return dp[0];
    }


    public static void main(String[] args) {
        删除并获得点数 res = new 删除并获得点数();
//        int[] nums = {3,4,2};
        int[] nums = {2,2,3,3,3,4};
        System.out.println(res.deleteAndEarn(nums));
    }
}
