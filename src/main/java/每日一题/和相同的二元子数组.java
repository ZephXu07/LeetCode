package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 和相同的二元子数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-08
 */
public class 和相同的二元子数组 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        /*
            前缀和，pre[num.length+1]
            pre[i] - pre[j] = goal 表示
            数组中下标为 j 到 i - 1 的这部分连续的值的和
            此时为题目所求的
            变换
            pre[j] = pre[i] - goal

            在我的算法中从左到遍历，且值为 0 或 1
            递增或者不变，pre[i] >= pre[j]
            pre[i] 为最新的从 0 到 i - 1 的和，
            此时哈希表中如果之前存在 pre[i] - goal 的值
            表示 j 到 i - 1 的这部分连续的值的和为 goal，次数多少，子数组则有多少

           开始时放入 0, 1，即 0 的次数为 1
           表示初始化，前缀和长度比原数组长度大 1
           如果从 0 到 i - 1 的值的和为 goal 才能计算得出
           0 = pre[i] - goal


         */
        int sum = 0;
        Map<Integer, Integer> count = new HashMap<>(nums.length + 1);
        int res = 0;
        for (int num : nums) {
            count.put(sum, count.getOrDefault(sum, 0) + 1);
            sum += num;
            res += count.getOrDefault(sum - goal, 0);
        }
        return res;
    }



}
