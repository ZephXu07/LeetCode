package labuladong;

/**
 * Title: labuladong.IsAnagram
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-09-14
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.length() == 0 || (s.charAt(0) == t.charAt(0) && s.length() == 1)) {
            return true;
        }
        int[] countS = new int[26];
        int[] countT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countS[s.charAt(i) - 'a'] ++;
            countT[t.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < countS.length; i++) {
            if (countS[i] != countT[i]) {
                return false;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "rat";

        String t = "car";
        boolean result = new IsAnagram().isAnagram(s, t);
        System.out.println(result);
    }
}
