package 剑指offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Title: 最长不含重复字符的子字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-06
 */
public class 最长不含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        if (null == s) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> windows = new HashMap<>();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        char c;
        char tmp;
        int res = 0;
        while (right < chars.length) {
            c = chars[right];
            right++;
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            while (windows.get(c) > 1) {
                tmp = chars[left];
                left ++;
                windows.put(tmp, windows.get(tmp) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public int lengthOfLongestSubstringDp(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> memo = new HashMap<>();
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        dp[1] = chars[1] == chars[0] ? 1 : 2;
        memo.put(chars[0], 0);
        memo.put(chars[1], 1);
        int left;
        int res = dp[1];
        for (int right = 2; right < chars.length; right++) {
            left = memo.getOrDefault(chars[right], -1);
            memo.put(chars[right], right);
            dp[right] = dp[right - 1] < right - left ? dp[right - 1] + 1 : right - left;
            res = Math.max(res, dp[right]);
        }
        return res;
    }

    public int lengthOfLongestSubstringDpOptimized(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> memo = new HashMap<>();
        char[] chars = s.toCharArray();
        int left;
        int res = 0;
        int tmp = 0;
        for (int right = 0; right < chars.length; right++) {
            left = memo.getOrDefault(chars[right], -1);
            memo.put(chars[right], right);
            tmp = tmp < right - left ? tmp + 1 : right - left;
            res = Math.max(res, tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        最长不含重复字符的子字符串 res = new 最长不含重复字符的子字符串();
        String s =  "pwwkew";
        System.out.println(res.lengthOfLongestSubstring(s));
        System.out.println(res.lengthOfLongestSubstringDp(s));
    }
}
