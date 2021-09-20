package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 连续的子数组和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-04
 */
public class 连续的子数组和 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) {
            return false;
            /*
                长度至少为 2
             */
        }
        Map<Integer, Integer> map = new HashMap<>();
        /*
            和与下标
         */
        map.put(0, -1);
        /*
            空与-1下标，当一个数 nums[0] 就满足时 0 - (-1) = 1
            因为map存储的前缀和是用 i 的下标而不是 i + 1
            举例
            0 1 2 3
            0 0 1 2  k = 3
             pre(0)-pre(-1) = 0 - 0 = 0 % 3 = 0
             0 -(-1) = 1
             当 i = 3 时，pre(3) - pre(1) = 3 % 3 = 0
             3 - 1 = 2 符合  1 2 ，长度为 2
         */
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            /*
                 ( pre(j) - pre (i) ) % k == 0 则 pre(j) % k == pre(i) % k
                 pre (i) % k = (a0 + a1 + ... + ai) % k = (a0 % k + a1 % k + ... ai % k ) % k
                 当前前缀和 % k 不会影响后面的前缀和 % k
             */
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
