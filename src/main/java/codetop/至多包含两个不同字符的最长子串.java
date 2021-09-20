package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 至多包含两个不同字符的最长子串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-15
 */
public class 至多包含两个不同字符的最长子串 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        /*
            或者一样的题
         */
        至多包含K个不同字符的最长子串 sss = new 至多包含K个不同字符的最长子串();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;
        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            if (!map.containsKey(r)) {
                count++;
            }
            map.put(r, map.getOrDefault(r, 0) + 1);
            right++;
            while (count > 2) {
                char l = s.charAt(left);
                int freq = map.get(l) - 1;
                if (freq == 0) {
                    count--;
                    map.remove(l);
                } else {
                    map.put(l, freq);
                }
                left++;
            }
            res = Math.max(res, right - left);
        }

        return res;
    }
}
