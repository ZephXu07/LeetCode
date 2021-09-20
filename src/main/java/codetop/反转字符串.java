package codetop;

/**
 * Title: 反转字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-10
 */
public class 反转字符串 {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }
}
