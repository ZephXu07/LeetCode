package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 等差数列划分II子序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-11
 */
public class 等差数列划分II子序列 {

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        /*
            题目没有长度为 2 的等差数列，直接返回 0
         */
        Map<Long, Integer>[] dp = new HashMap[len];
        for (int i = 0; i < len; i++) {
            dp[i] = new HashMap<>();
        }
        /*
            dp[i][diff] = value
           以 nums[i] 结尾，公差为 diff 的长度大于等于 2 的等差数列的个数 value
            由于需要一维来记录 diff ，
            不知道大小会浪费空间，
            使用 map 数组来记录
            map[i].get(diff) = value
            i ：以 nums[i] 结尾的
            diff：公差 为 diff
            value：值为等差数列个数（包含长度为 2，及 2 以上的）
         */

        int res = 0;
        for (int i = 1; i < len; i++) {
            /*
                从 1 开始即可，i > j，固定右边界，从左往右搜索
             */
            for (int j = 0; j < i; j++) {
                /*
                dp[i][diff] += (dp[j][diff] + 1)
                类似 等差数列划分，其是需要连续的，一次遍历，而此处是序列，可跳跃的
                固定了 i ，j [0, i)，使用前面的数 nums[j] 与边界 nums[i] 的公差，
                存放在map数组中  dp[i].get(diff) = value 数量
                如果 diff 不存在，即说明 nums[i] 与 nums[j] 的公差是第一次出现，
                即只有一个 nums[j] + diff = nums[i]
                如果 diff 存在，即说明 nums[i] 与 nums[j] 的公差是多次出现，
                即至少是 nums[j] + diff = nums[i], nums[k] + diff = nums[j] (k->[0,j))
                甚至多个，于是就有了多个子序列构成等差数列

                 */

                long diff = (long) nums[i] - nums[j];
                /*
                    nums[i] 与 nums[j] 的公差
                 */
                int keyI = dp[i].getOrDefault(diff, 0);
                /*
                    如果以 nums[i] 结尾的公差为 diff 的等差数列的个数 （序列长度包含2及2以上）
                 */
                int keyJ = dp[j].getOrDefault(diff, 0);
                /*
                    如果以 nums[j] 结尾的公差为 diff 的等差数列的个数 （序列长度包含2及2以上）
                    如果个数不为 0 ，又此处等差数列的构成是子序列，长度至少为 2 ，
                    再加上 nums[i] 与 nums[j] 的公差为 diff ，于是就有了长度至少为 3 的公差为 diff 的等差数列
                    所以，添加到等差数列的总数量中
                 */

                dp[i].put(diff, keyI + keyJ + 1);
                /*
                    dp[i][diff] += (dp[j][diff] + 1)
                    更新值，以 nums[i] 为结尾的子序列构成的等差数列的个数为
                    keyI + keyJ + 1 个
                 */

                res += keyJ;
                /*
                    keyJ 已经说明
                 */
            }
        }

        return res;
    }


}
