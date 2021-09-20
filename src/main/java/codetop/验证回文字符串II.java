package codetop;

/**
 * Title: 验证回文字符串II
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-29
 */
public class 验证回文字符串II {
    public boolean validPalindrome(String s) {
        return valid(s, 0, s.length() - 1, true);
    }

    private boolean valid (String s, int left, int right, boolean flag) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (flag) {
                    return valid(s, left + 1, right, false) ||
                            valid(s, left, right - 1, false);
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        验证回文字符串II res = new 验证回文字符串II();
        System.out.println(res.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
