package labuladong;

/**
 * Title: labuladong.ReverseString
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-09-13
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int len = s.length / 2;
        char tmp;
        for (int i = 0; i < len; i++) {
            tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        System.out.println(s);
        new ReverseString().reverseString(s);
    }
}
