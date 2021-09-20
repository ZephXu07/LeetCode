package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 单词规律
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-16
 */
public class 单词规律 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mapping = new HashMap<>();
        char[] p = pattern.toCharArray();
        int pLen = p.length;
        String[] strs = s.split(" ");
        int sLen = strs.length;
        if (pLen != sLen) {
            return false;
        }
        String value;
        for (int i = 0; i < pLen; i++) {
            if (!mapping.containsKey(p[i]) && !mapping.containsValue(strs[i])) {
                mapping.put(p[i], strs[i]);
            } else {
                value = mapping.get(p[i]);
                if (!strs[i].equals(value)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";

        String s = "dog dog dog dog";
        单词规律 res = new 单词规律();
        System.out.println(res.wordPattern(pattern, s));
    }
}
