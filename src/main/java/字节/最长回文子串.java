package 字节;

/**
 * Title: 最长回文子串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-17
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {
        int[] res = {0,0,0};
        int[] s1;
        int[] s2;
        for (int i = 0; i < s.length(); i++) {
            s1 = palindrome(s, i, i);
            s2 = palindrome(s, i, i + 1);
            res = longestString(res, s1, s2);
        }
        return s.substring(res[0], res[1]);
    }

    private int[] palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return new int[]{left + 1, right, right - left - 1};
    }

    private int[] longestString(int[]  s1, int[]  s2, int[]  s3) {
        if (s1[2] > s2[2]) {
            return s1[2] > s3[2] ? s1 : s3;
        } else {
            return s2[2] > s3[2] ? s2 : s3;
        }
    }

    public static void main(String[] args) {
        最长回文子串 res = new 最长回文子串();
        String s = "ac";
        System.out.println(res.longestPalindrome(s));
    }
}
