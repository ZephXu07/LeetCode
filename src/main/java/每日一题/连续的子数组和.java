package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 连续的子数组和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-02
 */
public class 连续的子数组和 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] pre = new int[len + 1];

        for (int i = 0; i < len; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        Map<Integer, Integer> memo = new HashMap<>(len);
        memo.put(0, -1);
        for (int i = 0; i < len; i++) {
            int tmp = pre[i] % k;
            if (memo.containsKey(tmp) && i - memo.get(tmp) >= 2) {
                return true;
            } else {
                memo.put(tmp, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        连续的子数组和 res = new 连续的子数组和();
//        int[] nums = {23,2,4,6,7};
//        int k = 6;
//        int[] nums = {23,2,423,2,6,4,7};
//        int k = 6;
        int[] nums = {23,2,6,4,7};
        int k = 13;
        System.out.println(res.checkSubarraySum(nums, k));
    }
}
