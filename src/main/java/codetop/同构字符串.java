package codetop;

import labuladong.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 同构字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-08
 */
public class 同构字符串 {
//    public boolean isIsomorphic(String s, String t) {
//        Map<Character, Character> s2t = new HashMap<>();
//        Map<Character, Character> t2s = new HashMap<>();
//        int len = s.length();
//        for (int i = 0; i < len; ++i) {
//            char x = s.charAt(i), y = t.charAt(i);
//            if ((s2t.containsKey(x) && s2t.get(x) != y)
//                    || (t2s.containsKey(y) && t2s.get(y) != x)) {
//                return false;
//            }
//            s2t.put(x, y);
//            t2s.put(y, x);
//        }
//        return true;
//    }

    public boolean isIsomorphic(String s, String t) {
        for(int i = 0; i < s.length(); i++){
            /*
                同构的话两个字符在各自的字符串中下标会是一样的
             */
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
