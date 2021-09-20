package labuladong;

/**
 * Title: labuladong.IsPalindrome
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-09-15
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "";
        boolean result = new IsPalindrome().isPalindrome(s);
        System.out.println(result);

    }

}
