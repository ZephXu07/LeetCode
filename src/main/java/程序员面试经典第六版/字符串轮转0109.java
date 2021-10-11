package 程序员面试经典第六版;

/**
 * Title: 字符串轮转0109
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-11
 */
public class 字符串轮转0109 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s1 + s2).contains(s2);
    }
}
