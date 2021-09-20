package codetop;

/**
 * Title: 最长回文串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-07
 */
public class 最长回文串 {
    public int longestPalindrome(String s) {
        /*

         */
        int len = s.length();
        int[] count = new int[52];

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c <= 'Z') {
                count[(c - 'A') + 26]++;
            } else {
                count[(c - 'a')]++;
            }
        }

        boolean flag = false;
        int res = 0;
        for (int n : count) {
            if ((n & 1) == 1 && !flag) {
                res += 1;
                flag = true;
            }
            res += n / 2 * 2;
        }
        return res;
    }
}
