package 剑指offer专项突击版;

/**
 * Title: 外星语言是否排序034
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-03
 */
public class 外星语言是否排序034 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (!isLess(words[i - 1], words[i], map)) {
                return false;
            }
        }
        return true;
    }

    private boolean isLess (String s, String t, int[] map) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            int val1 = map[s.charAt(i) - 'a'];
            int val2 = map[t.charAt(i) - 'a'];
            if (val1 == val2) {
                i++;
                j++;
            } else {
                return val1 < val2;
            }
        }
        return i == s.length();

    }
}
