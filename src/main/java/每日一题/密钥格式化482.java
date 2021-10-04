package 每日一题;

/**
 * Title: 密钥格式化482
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-04
 */
public class 密钥格式化482 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '-') {
                continue;
            }
            if ('a' <= c && c <= 'z') {
                c = (char) (c - 'a' + 'A');
            }
            if (count == k) {
                res.append('-').append(c);
                count = 1;
            } else {
                res.append(c);
                count++;
            }
        }
        if (res.length() > k && res.charAt(0) == '-') {
            res.deleteCharAt(0);
        }
        return res.reverse().toString();
    }


    public static void main(String[] args) {
        密钥格式化482 res = new 密钥格式化482();
        System.out.println(res.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(res.licenseKeyFormatting("2-5g-3-J", 2));
    }
}
