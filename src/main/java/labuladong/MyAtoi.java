package labuladong;

/**
 * Title: labuladong.MyAtoi
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-09-15
 */
public class MyAtoi {
    public int myAtoi(String str) {
        if (str.length() == 0 || (str.length() == 1 && !(str.charAt(0) - '0' >= 0 && str.charAt(0) - '0' <= 9))) {
            return 0;
        }
        int count = 0;
        boolean negative = false;
        while (count < str.length() && ((str.charAt(count) == ' '))) {
            count ++;
        }
        if (count == str.length()) {
            return 0;
        }
        if (str.charAt(count) == '-' || str.charAt(count) == '+') {
            negative = str.charAt(count) == '-';
            count ++;
        }
        if (!(str.charAt(count) - '0' >= 0 && str.charAt(count) - '0' <= 9)) {
            return 0;
        }
        long result = 0;
        for (; count < str.length() && (str.charAt(count) - '0' >= 0 && str.charAt(count) - '0' <= 9);count++) {
            result = result * 10 + (str.charAt(count) - '0');
            if (result > Integer.MAX_VALUE) {
                return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
        }
        if (negative) {
            return (-result) > Integer.MIN_VALUE?(int)(-result):Integer.MIN_VALUE;

        } else {
            return result < Integer.MAX_VALUE? (int) result :Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
//        String str = "0-1";
//        String str = "4193 with words";
//        String str = "42";
//        String str = "-42";
//        String str = "words and 987";
        String str = "-91283472332";
        int myAtoi = new MyAtoi().myAtoi(str);
        System.out.println(myAtoi);
    }
}
