package codetop;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Title: 至多包含K个不同字符的最长子串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-25
 */
public class 至多包含K个不同字符的最长子串 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        if (len * k == 0) {
            return 0;
            /*
                一次性判断两个是否至少有一个为 0
             */
        }
        int left = 0;
        int right = 0;
        int res = k;
        Map<Character, Integer> map = new HashMap<>(k + 1);
        /*
            key 为字符
            value 为字符在 s[left] ... s[right] 中最右边那个下标

            当种类大于 k 时，找到最小的下标，移除这个字符

            例如
            aaacb   k = 2
            01234

            此时移除 a，下标为 2 ,[left,right]=[3,5] right - left = 2 = cb 的长度

            acab    k = 2
            0123
            此时移除 c，下标为 1 ,[left,right]=[2,4] right - left = 2 = ab 的长度

            acb
            012
            此时移除 a，下标为 0 ,[left,right]=[1,3] right - left = 2 = cb 的长度
         */
        while (right < len) {
            map.put(s.charAt(right), right);
            right++;
            if (map.size() > k) {
                int min = Collections.min(map.values());
                map.remove(s.charAt(min));
                left = min + 1;
            }
            res = Math.max(res, right - left);


        }
        return res;
    }
}
