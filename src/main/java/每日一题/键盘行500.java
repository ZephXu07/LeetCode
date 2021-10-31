package 每日一题;

import java.util.*;

/**
 * Title: 键盘行500
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-31
 */
public class 键盘行500 {
    private static final String chars = "12210111011122000010020202";
    public String[] findWords(String[] words) {
        List<String> list = new LinkedList<>();
        for (String word : words) {
            String w = word.toLowerCase();
            int type = chars.charAt(w.charAt(0) - 'a');
            boolean flag = true;
            for (int i = 1; i < w.length(); i++) {
                if (chars.charAt(w.charAt(i) - 'a') != type) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(word);
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
