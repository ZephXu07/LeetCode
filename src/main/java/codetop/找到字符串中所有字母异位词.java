package codetop;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Title: 找到字符串中所有字母异位词
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-08
 */
public class 找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int valid = 0;
        int left = 0;
        int right = 0;
        List<Integer> res = new LinkedList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;
            if (need.containsKey(c)) {
                /*
                    不符合 p 字符串的就不添加了
                    即使因为几个字符中只有一个字符不符合也不添加
                    因为长度是固定的，少了一个字符不可能成功
                    减少添加还能减少移除
                 */
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    /*
                        次数也要一样
                     */
                    valid ++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left ++;
                /*
                    移除左边，但是 p 的字符才更新 window，
                    因为我们是 p 的字符才添加到 window
                 */
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid --;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }
}
