package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 最长定差子序列1218
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-05
 */
public class 最长定差子序列1218 {
    public int longestSubsequence(int[] arr, int difference) {
//        int len = arr.length;
//        int[] dp = new int[len];
//        int res = 1;
//        dp[0] = 1;
//        for (int i = 1; i < len; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if (arr[i] - arr[j] == difference) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            res = Math.max(res, dp[i]);
//        }
//        return res;


        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int a : arr) {
            map.put(a, map.getOrDefault(a - difference, 0) + 1);
            res = Math.max(res, map.get(a));
        }
        return res;
    }
}
