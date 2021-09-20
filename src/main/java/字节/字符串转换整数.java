package 字节;

/**
 * Title: 字符串转换整数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-08
 */
public class 字符串转换整数 {
    public int myAtoi(String str) {
        if (str.length() == 0 ||
                (str.length() == 1 && !(str.charAt(0) - '0' >= 0 && str.charAt(0) - '0' <= 9))) {
            return 0;
            //长度为0或者长度为1但不是数字，返回0
        }
        int count = 0;
        //字符串下标，来得到字符，顺便计算空格数
        boolean negative = false;
        while (count < str.length() && ((str.charAt(count) == ' '))) {
            count ++;
            //去除前导空格
        }
        if (count == str.length()) {
            return 0;
            //发现整个字符串都是空格
        }
        if (str.charAt(count) == '-' || str.charAt(count) == '+') {
            negative = str.charAt(count) == '-';
            //判断正负号
            count ++;
        }
        if (!(str.charAt(count) - '0' >= 0 && str.charAt(count) - '0' <= 9)) {
            return 0;
            //存在不是数字，则整个字符串非法，返回0
        }
        long result = 0;
        //结果
        for (; count < str.length() && (str.charAt(count) - '0' >= 0 && str.charAt(count) - '0' <= 9);count++) {
            //当没遍历完字符串且字符是数字时，继续遍历
            result = result * 10 + (str.charAt(count) - '0');
            //计算数值
            if (result > Integer.MAX_VALUE) {
                //大于int最大值
                return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
                //根据正负返回值
            }
        }
        if (negative) {
            //同理
            return (-result) > Integer.MIN_VALUE?(int)(-result):Integer.MIN_VALUE;

        } else {
            return result < Integer.MAX_VALUE? (int) result :Integer.MAX_VALUE;
        }
    }
}
