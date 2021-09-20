package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 字符串排列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-02-10
 */
public class 字符串排列 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int valid = 0;
        int left = 0;
        int right = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right ++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid ++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left ++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid --;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
