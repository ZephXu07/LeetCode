package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 最长不含重复字符的子字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-12
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
        /*
            字符与次数
         */
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        char c;
        char tmp;
        int res = 0;
        /*
            不重复字符串长度
         */
        while (right < chars.length) {
            c = chars[right];
            right++;
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            /*
                添加到窗口中
             */
            while (windows.get(c) > 1) {
                /*
                    新添加的字符使窗口内的字符重复了
                 */
                tmp = chars[left];
                left ++;
                windows.put(tmp, windows.get(tmp) - 1);
                /*
                    移除左边界的字符，即使不是造成重复的字符，直到将重复的字符移除一个
                 */
            }
            res = Math.max(res, right - left);
            /*
                计算长度与比较
             */
        }
        return res;
    }

    public int lengthOfLongestSubstring0(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        /*
            哈希表统计每个字符最后出现的次数
            dp[i] 以 s,charAt(i) 结尾的不重复字符串最长长度
        */
        Map<Character, Integer> memo = new HashMap<>();
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        dp[1] = chars[1] == chars[0] ? 1 : 2;
        /*
            如果 0 与 1 相同，dp[1] 自然为 1，否则就是 2 了

         */
        memo.put(chars[0], 0);
        memo.put(chars[1], 1);
        /*
            存入两个字符最后出现的下标，如果是相同则被覆盖了
         */
        int left;
        int res = dp[1];
        /*
            结果，至少为 1 ，可能为 2
         */
        for (int right = 2; right < chars.length; right++) {
            /*
                右边界扩大
             */
            left = memo.getOrDefault(chars[right], -1);
            /*
                得到这个字符的上次出现地方，如果不存在则是 -1
                在下面的计算长度中直接 right - left 即可得到长度，不必 +1
             */
            memo.put(chars[right], right);
            /*
                继续更新
             */
            dp[right] = dp[right - 1] < right - left ? dp[right - 1] + 1 : right - left;
            /*
                以 right 字符结尾的不重复字符串长度
                如果 right - 1 的长度小于两个重复的字符之间的长度，则是这个长度
                否则则是上一个 字符结尾的长度 + 1，因为 right字符即使没有出现重复，
                也有其他字符出现重复，否则是不会小于 right - left
             */
            res = Math.max(res, dp[right]);
            /*
                每个都在更新，得到整个字符串的最长不重复长度
             */
        }

        return res;
    }

}
