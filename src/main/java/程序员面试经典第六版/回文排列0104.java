package 程序员面试经典第六版;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 回文排列0104
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-11-05
 */
public class 回文排列0104 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean flag = false;
        for (int i : map.values()) {
            if (i % 2 == 1) {
                if (!flag) {
                    flag = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
