package codetop;

/**
 * Title: 赎金信383
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-06
 */
public class 赎金信383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            freq[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--freq[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
