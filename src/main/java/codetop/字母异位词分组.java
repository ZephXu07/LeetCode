package codetop;

import java.util.*;

/**
 * Title: 字母异位词分组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-04
 */
public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
            统计字符种类与数量
            重新组织字符串，map保存
         */
        if (null == strs || 0 == strs.length) {
            return new ArrayList<>();
        }
        Map<String, List<String>> memo = new HashMap<>();
        for (String str:strs) {
            char[] chars = new char[26];
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (chars[i] != 0) {
                    builder.append(i + 'a').append(chars[i]);
                }
            }
            String key = builder.toString();
            List<String> list = memo.getOrDefault(key, new LinkedList<>());
            list.add(str);
            memo.put(key, list);
        }
        return new LinkedList<>(memo.values());
    }
}
