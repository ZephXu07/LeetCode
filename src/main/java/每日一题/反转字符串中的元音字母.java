package 每日一题;

/**
 * Title: 反转字符串中的元音字母
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-19
 */
public class 反转字符串中的元音字母 {
    public String reverseVowels(String s) {
        int len = s.length();
        int left = 0;
        int right = len - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            while (left < right && !isVowels(chars[left])) {
                left++;
            }
            if (left >= right) {
                break;
            }
            while (right > left && !isVowels(chars[right])) {
                right--;
            }
            if (right <= left) {
                break;
            }
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left++;
            right--;
        }
        return new String(chars);
    }

    private boolean isVowels (char c) {
        char[] vowels = {'a','e','i','o','u', 'A', 'E', 'I', 'O', 'U'};
        for (char v : vowels) {
            if (v == c) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        反转字符串中的元音字母 res = new 反转字符串中的元音字母();
        System.out.println(res.reverseVowels("hello"));
        System.out.println(res.reverseVowels("leetcode"));
    }
}
