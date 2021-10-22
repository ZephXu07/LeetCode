package 杂类;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 单词规律290
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-22
 */
public class 单词规律290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> cha = new HashMap<>();
        Map<String, Character> word = new HashMap<>();
        //可用双map，减少时间，containsValue需遍历整个
        char[] p = pattern.toCharArray();
        int pLen = p.length;
        String[] strs = s.split(" ");
        int sLen = strs.length;
        if (pLen != sLen) {
            return false;
        }
        String value;
        for (int i = 0; i < pLen; i++) {
            if (!cha.containsKey(p[i]) && !word.containsKey(strs[i])) {
                cha.put(p[i], strs[i]);
                word.put(strs[i], p[i]);
            } else {
                value = cha.get(p[i]);
                if (!strs[i].equals(value)) {
                    return false;
                }
            }
        }
        return true;
    }
}
