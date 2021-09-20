package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: 变位词组
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-18
 */
public class 变位词组 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    builder.append(i).append(":").append(count[i]);
                }
            }
            String tmp = builder.toString();
            if (map.containsKey(tmp)) {
                map.get(tmp).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(tmp, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
       String[] strs = {"eat", "tea"};
       groupAnagrams(strs);
    }
}
