package 每日一题;

/**
 * Title: 反转字符串二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-20
 */
public class 反转字符串二 {
    public String reverseStr(String s, int k) {
        int fast = -1;
        char[] chars = s.toCharArray();
        int len = s.length();
        while (fast < len - 1) {
            fast = fast + 2 * k ;
            int slow = fast - k;
            if (k >= len) {
                reverse(chars, 0, len - 1);
                break;
            } else if (fast < len) {
                reverse(chars, slow + 1 - k, slow);
            } else if (slow >= len) {
                reverse(chars, slow + 1 - k, len - 1);
                break;
            } else {
                reverse(chars, slow + 1 - k, slow);
                break;
            }
        }
        return new String(chars);
    }

    private void reverse (char[] chars, int i, int j) {
        while (i < j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        反转字符串二 res = new 反转字符串二();
        System.out.println(res.reverseStr("abcdefg", 8) + " gfedcba");
        System.out.println(res.reverseStr("abcdefg", 2) + " bacdfeg");
        System.out.println(res.reverseStr("abcdefg", 3) + " cbadefg");
        System.out.println(res.reverseStr("ba", 1) + " ba" );
        System.out.println(res.reverseStr("abcd", 2) + " bacd");
    }
}
