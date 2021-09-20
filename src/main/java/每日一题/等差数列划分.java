package 每日一题;

/**
 * Title: 等差数列划分
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-10
 */
public class 等差数列划分 {
    public int numberOfArithmeticSlices0(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[len];
        /*
            从 nums[0]开始，且以 nums[i] 结尾的等差数列

            由题目有 dp[0] = 0，dp[1] = 0

            因为长度至少为 3，所以下标至少是 2 开始遍历
            此时如果 diff = nums[1]-nums[0] == nums[i] - nums[i-1]
            则 dp[2] = dp[1] + 1

            而题目要求的是等差数列的数量，所以使用 res 来记录每个 i 结尾的数量，此刻可以从 i = 2 开始

            0 1 2 3
            1 2 3 4
            dp[0] = 0, dp[1] = 0
            dp[2] = dp[1] + 1 = 1, 因为是 nums[2] 结尾的等差数列有 0 1 2
            dp[3] = dp[1] + 1 = 2，同理有 0 1 2 3, 1 2 3

            而求的是全部，则有 dp[0] + ... + dp[3] = 3

            而如果出现不一样，diff 需要进行新的计算，然后再下一轮再统计
            0 1 2 3 4 5
            1 2 3 4 6 8
            dp[0]=0 dp[1]=0
            dp[2]=1 dp[3]=2
            dp[4]=0 dp[5]=1

            dp[0] + ... + dp[5] = 4

         */
        int diff = nums[1] - nums[0];
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            } else {
                diff = nums[i] - nums[i - 1];
            }
        }
        return res;
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return 0;
        }
        int res = 0;
//        int[] dp = new int[len];
        int pre = 0;
        int cur = 0;
        /*
            从 nums[0]开始，且以 nums[i] 结尾的等差数列

            由题目有 dp[0] = 0，dp[1] = 0

            因为长度至少为 3，所以下标至少是 2 开始遍历
            此时如果 diff = nums[1]-nums[0] == nums[i] - nums[i-1]
            则 dp[2] = dp[1] + 1

            而题目要求的是等差数列的数量，所以使用 res 来记录每个 i 结尾的数量，此刻可以从 i = 2 开始

            0 1 2 3
            1 2 3 4
            dp[0] = 0, dp[1] = 0
            dp[2] = dp[1] + 1 = 1, 因为是 nums[2] 结尾的等差数列有 0 1 2
            dp[3] = dp[1] + 1 = 2，同理有 0 1 2 3, 1 2 3

            而求的是全部，则有 dp[0] + ... + dp[3] = 3

            而如果出现不一样，diff 需要进行新的计算，然后再下一轮再统计
            0 1 2 3 4 5
            1 2 3 4 6 8
            dp[0]=0 dp[1]=0
            dp[2]=1 dp[3]=2
            dp[4]=0 dp[5]=1

            dp[0] + ... + dp[5] = 4

         */
        int diff = nums[1] - nums[0];
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == diff) {
//                dp[i] = dp[i - 1] + 1;
//                res += dp[i];
                cur = pre + 1;
                res += cur;
                pre = cur;
            } else {
                diff = nums[i] - nums[i - 1];
                pre = 0;
            }
        }
        return res;
    }
}
