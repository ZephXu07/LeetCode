package 剑指offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Title: 第一个只出现一次的字符
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-04
 */
public class 第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        Map<Character, Boolean> memo = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            memo.put(c, !memo.containsKey(c));
        }
        for(Map.Entry<Character, Boolean> res : memo.entrySet()) {
            if (res.getValue()) {
                return res.getKey();
            }
        }
        return ' ';
    }

}

