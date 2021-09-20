package 剑指offer;

/**
 * Title: 替换空格
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-29
 */
public class 替换空格 {
    public String replaceSpace(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) {
                count ++;
            }
        }
        char[] chars = new char[s.length() + 2 * count];
        int p = s.length() - 1;
        int q = chars.length - 1;
        while (p >= 0) {
            if (' ' == s.charAt(p)) {
                chars[q--] = '0';
                chars[q--] = '2';
                chars[q--] = '%';
            } else {
                chars[q--] = s.charAt(p);
            }
            p --;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        替换空格 res = new 替换空格();
        System.out.println(res.replaceSpace("We are happy."));
    }
}
