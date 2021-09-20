package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 找不同
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-18
 */
public class 找不同 {
    public char findTheDifference(String s, String t) {
//        Map<Character, Integer> memo = new HashMap<>(26);
//        for (int i = 0; i < s.length(); i++) {
//            memo.put(s.charAt(i), memo.getOrDefault(s.charAt(i), 0) + 1);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            if (memo.containsKey(t.charAt(i)) && memo.get(t.charAt(i)) != 0) {
//                memo.put(t.charAt(i), memo.get(t.charAt(i)) - 1);
//                continue;
//            }
//            return t.charAt(i);
//        }
//        return ' ';
//        int[] cnt = new int[26];
//        for (int i = 0; i < s.length(); ++i) {
//            char ch = s.charAt(i);
//            cnt[ch - 'a']++;
//        }
//        for (int i = 0; i < t.length(); ++i) {
//            char ch = t.charAt(i);
//            cnt[ch - 'a']--;
//            if (cnt[ch - 'a'] < 0) {
//                return ch;
//            }
//        }
//        return ' ';
//        int as = 0, at = 0;
//        for (int i = 0; i < s.length(); ++i) {
//            as += s.charAt(i);
//        }
//        for (int i = 0; i < t.length(); ++i) {
//            at += t.charAt(i);
//        }
//        return (char) (at - as);

//        int ret = 0;
//        for (int i = 0; i < s.length(); ++i) {
//            ret ^= s.charAt(i);
//        }
//        for (int i = 0; i < t.length(); ++i) {
//            ret ^= t.charAt(i);
//        }
//        return (char) ret;
        int ret = 0;
        int i = 0;
        for (; i < s.length(); ++i) {
            ret = ret ^ s.charAt(i) ^ t.charAt(i);
        }
        return (char) (ret ^ t.charAt(i));
    }

    public static void main(String[] args) {
        找不同 res = new 找不同();
        String s = "";
        String t = "y";
        System.out.println(res.findTheDifference(s, t));
    }
}
