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

//    public List<String> findRepeatedDnaSequences(String s) {
//        List<String> res = new LinkedList<>();
//        Map<String, Integer> map = new HashMap<>();
//        int len = s.length() - 10;
//        for (int i = 0; i <= len; i++) {
//            String tmp = s.substring(i, i + 10);
//            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
//            if (map.get(tmp) == 2) {
//                res.add(tmp);
//            }
//        }
//
//        return res;
//    }


    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<>();
        if (s.length() < 10) {
            return res;
        }
        /*
            滑动窗口，字符映射
            一个字符映射两位，10个字符映射 20 位
         */
        Map<Character, Integer> map = new HashMap<Character, Integer>(4){{
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }};
        int hash = 0;
        for (int i = 0; i < 9; i++) {
            /*
                先添加 9 个字符
             */
            hash = (hash << 2) | map.get(s.charAt(i));
        }
        int len = s.length() - 10;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i <= len; i++) {
            hash = ((hash << 2) | (map.get(s.charAt(i + 9)))) & ((1 << 20) - 1);
            /*
                hash << 2 | map.get(s.charAt(i + 9))
                添加右边界
                & (1 << 20 - 1);
                1 << 20 从右到左 第 0 位开始第 20 位是 1 ，其余为 0
                减 1 则 从右到左  第 0 位开始到第 19 位都是 1

                取余则获得了新的 20 位的数字

                其余同理
             */
            count.put(hash, count.getOrDefault(hash, 0) + 1);

            if (count.get(hash) == 2) {
                res.add(s.substring(i, i + 10));
            }
        }
        return res;
    }
}
