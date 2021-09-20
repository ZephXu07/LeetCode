package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 连续数组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-03
 */
public class 连续数组 {
    public int findMaxLength(int[] nums) {
//        int len = nums.length;
//        if (len == 1) {
//            return 0;
//        }
//        if (len == 2) {
//            return nums[0] + nums[1] == 1 ? 2 : 0;
//        }
//
//        int[] pre = new int[len + 1];
//        for (int i = 0; i < len; i++) {
//            pre[i + 1] = pre[i] + nums[i];
//        }
//
//        int max = 0;
//        for (int i = 0; i <= len - 2; i++) {
//            for (int j = 2; j <= len; j++) {
//                int size = j - i;
//                if (size >= 2 && (size & 1) == 0 && (size / 2) == (pre[j] - pre[i])) {
//                    max = Math.max(max, size);
//                }
//            }
//        }
//        return max;


        /*
            1 --> ++
            0 --> --
            则 pre[j] - pre[i] = 0
            (0, -1) 代表前缀和为空时
            例如 [0, 1]，此时是 (0, 1) 1 - (-1) == 2 长度
            又因为即使是 0 = 0，但 0 - (-1) = 1 小于最长长度，不需要排除，即使不符合题意也被覆盖了
         */
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        if (len == 2) {
            return nums[0] + nums[1] == 1 ? 2 : 0;
        }

        Map<Integer, Integer> map = new HashMap<>(len);
        map.put(0, -1);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            sum = nums[i] == 0 ? sum - 1 : sum + 1;
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return max;
    }
}
