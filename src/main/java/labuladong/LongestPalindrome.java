package labuladong;

/**
 * Title: labuladong.LongestPalindrome
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-17
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String res = "";
        String s1;
        String s2;
        for (int i = 0; i < s.length() - 1; i++) {
            s1 = palindrome(s, i, i);
            s2 = palindrome(s, i, i + 1);
            res = longestString(res, s1, s2);
        }
        return res;
    }
    private String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return s.substring(left + 1, right);
    }

    private String longestString(String s1, String s2, String s3) {
        if (s1.length() > s2.length()) {
            return s1.length() > s3.length() ? s1 : s3;
        } else {
            return s2.length() > s3.length() ? s2 : s3;
        }
    }

    public static void main(String[] args) {
        LongestPalindrome res = new LongestPalindrome();
        String s = res.longestPalindrome("aacdefcaa");
        System.out.println(s);

    }
}
