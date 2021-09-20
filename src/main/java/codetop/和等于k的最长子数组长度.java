package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 和等于k的最长子数组长度
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-08
 */
public class 和等于k的最长子数组长度 {
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = 0;
        /*
            前缀和
            pre[j] - pre[i] = k
            j - i 最大
         */
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if (map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        和等于k的最长子数组长度 res = new 和等于k的最长子数组长度();
        System.out.println(res.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3) + "\t4");
        System.out.println(res.maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1) + "\t2");
    }
}
