package 每日一题;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Title: 重复的DNA序列187
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-08
 */
public class 重复的DNA序列187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        int len = s.length() - 10;
        for (int i = 0; i <= len; i++) {
            String tmp = s.substring(i, i + 10);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            if (map.get(tmp) == 2) {
                res.add(tmp);
            }
        }

        return res;
    }
}
