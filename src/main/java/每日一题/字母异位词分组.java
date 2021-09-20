package 每日一题;

import java.util.*;

/**
 * Title: 字母异位词分组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-14
 */
public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
//        if (null == strs || 0 == strs.length) {
//            return new ArrayList<>();
//        }
//        Map<String, List<String>> memo = new HashMap<>();
//        for (String str:strs) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            String key = new String(chars);
//            List<String> list = memo.getOrDefault(key, new LinkedList<>());
//            list.add(str);
//            memo.put(key, list);
//        }
//        return new LinkedList<List<String>>(memo.values());



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
                builder.append(chars[i] + 'a');
            }
            String key = builder.toString();
            List<String> list = memo.getOrDefault(key, new LinkedList<>());
            list.add(str);
            memo.put(key, list);
        }
        return new LinkedList<>(memo.values());

    }

    public static void main(String[] args) {
        字母异位词分组 res = new 字母异位词分组();
        String[] strs = {"ac","c"};
        System.out.println(res.groupAnagrams(strs));
    }
}

