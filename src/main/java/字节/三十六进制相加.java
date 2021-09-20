package 字节;

/**
 * Title: 三十六进制相加
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-27
 */
public class 三十六进制相加 {
    public String addStrings(String num1, String num2) {
        int inx1 = num1.length() - 1;
        int inx2 = num2.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (inx1 >= 0 || inx2 >= 0 || carry != 0) {
            int a = inx1 >= 0 ? getInt(num1.charAt(inx1)) : 0;
            int b = inx2 >= 0 ? getInt(num2.charAt(inx2)) : 0;
            int sum = a + b + carry;
            builder.append(sum % 36);
            carry = sum / 36;
            inx1 --;
            inx2 --;
        }
        return builder.reverse().toString();
    }

    private char getChar (int n) {
        if (0 <= n && n <= 9) {
            return (char) (n + '0');
        } else {
            return (char)(n - 10 + 'a');
        }
    }

    private int getInt (char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        } else {
            return c - 'a' + 10;
        }
    }

    public static void main(String[] args) {
        三十六进制相加 res = new 三十六进制相加();
        String num1 = "1b";
        String num2 = "2x";
        System.out.println(res.addStrings(num1, num2));
    }
}
