package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 同构字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-27
 */
public class 同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sC = s.charAt(i);
            char tC = t.charAt(i);
            if (sToT.containsKey(sC) && !tToS.containsKey(tC)) {
                return false;
            }
            if (!sToT.containsKey(sC) && tToS.containsKey(tC)) {
                return false;
            }
            if (!sToT.containsKey(sC) && !tToS.containsKey(tC)) {
                sToT.put(sC,tC);
                tToS.put(tC,sC);
                continue;
            }
            if (sC != tToS.get(tC) || sToT.get(sC) != tC) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        同构字符串 res = new 同构字符串();
        String s = "ab";
        String t = "aa";
        System.out.println(res.isIsomorphic(s, t));
    }
}
