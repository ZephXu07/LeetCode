package codetop;

/**
 * Title: 字符串中的第一个唯一字符
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-07
 */
public class 字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
