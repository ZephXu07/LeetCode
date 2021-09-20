package 腾讯;

/**
 * Title: 字符串相减
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-14
 */
public class 字符串相减 {

    public String subStrings (String num1, String num2) {
        if (isLess(num1, num2)) {
            String res = sub(num2, num1);
            if (res != "0") {
                return "-" + res;
            } else {
                return res;
            }
        } else {
            return sub(num1, num2);
        }
    }

    private String sub(String num1, String num2) {
        int inx1 = num1.length() - 1;
        int inx2 = num2.length() - 1;
        int borrow = 0;
        StringBuilder builder = new StringBuilder();
        while (inx1 >= 0 || inx2 >= 0) {
            int x = inx1 >= 0? num1.charAt(inx1) - '0' : 0;
            int y = inx2 >= 0? num2.charAt(inx2) - '0' : 0;
            int res;
            if (x - y - borrow >= 0) {
                res = x - y - borrow;
                borrow = 0;

            } else {
                res = x + 10 - y - borrow;
                borrow = 1;
            }
            builder.append(res);
            inx1--;
            inx2--;
        }
        builder.reverse();
        int inx = 0;
        for (; inx < builder.length() - 1; inx++) {
            if (builder.charAt(inx) != '0') {
                break;
            }
        }
        return builder.substring(inx);
    }

    private boolean isLess (String num1, String num2) {
        if (num1.length() == num2.length()) {
            return num1.compareTo(num2) < 1;
        } else {
            return num1.length() < num2.length();
        }
    }


    public static void main(String[] args) {
        字符串相减 sub = new 字符串相减();
        String num1 = "131";
        String num2 = "19";
        System.out.println(sub.subStrings(num1, num2));
    }
}
