package codetop;

import java.util.HashSet;
import java.util.Set;

/**
 * Title: 最长连续序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-27
 */
public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        /*
            哈希表去重，顺便 O(n)复杂度
         */
        for (int i : nums) {
            set.add(i);
        }
        int res = 0;
        for (int s : set) {
            /*
                如果包含 s - 1，表示，它可以被 s - 1 牵进来，
                即使 s + 1 存在，长度也小于 s - 1 开始的序列，
                于是跳过
             */
            if (set.contains(s - 1)) {
                continue;
            }
            int i = 1;
            int len = 0;
            /*
                计算有多少连续
             */
            while (set.contains(s + i)) {
                len++;
                i++;
            }
            res = Math.max(res, len);
            /*
                比较
             */
        }
        return res;
    }
}
