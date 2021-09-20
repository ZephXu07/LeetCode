package codetop;

/**
 * Title: 整数转罗马数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-31
 */
public class 整数转罗马数字 {
    public String intToRoman(int num) {
        /*
            贪心，模拟
         */
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        /*
            枚举所有的单位值与其符号
            从大到小遍历
         */

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                /*
                    此处使用 while
                    例如 800
                    - 500 = 300
                    遍历到 100 时使用三次
                 */
                res.append(symbols[i]);
                num -= values[i];
            }

            if (num == 0) {
                break;
            }
        }

        return res.toString();
    }
}
