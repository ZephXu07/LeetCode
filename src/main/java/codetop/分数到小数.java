package codetop;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 分数到小数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-30
 */
public class 分数到小数 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            /*
                异或，如果只有一个小于 0，则只出现一个 true，一个 false
                结果是 true，商为负数

             */
            res.append('-');
        }
        long n = Math.abs(Long.valueOf(numerator));
        long d = Math.abs(Long.valueOf(denominator));
        /*
            防止除法后溢出
         */
        res.append(n / d);
        /*
            加入商
         */
        long r = n % d;
        /*
            余数
         */
        if (r == 0) {
            /*
                余数为 0 直接返回
             */
            return res.toString();
        }
        res.append('.');
        /*
            余数不为 0 出现小数需要 '.'
         */

        Map<Long, Integer> map = new HashMap<>();

        /*
            记录数字即当时的字符串长度
         */

        while (r != 0) {
            /*
                直到余数为 0 或者出现重复节
             */
            if (map.containsKey(r)) {
                /*
                    出现重复节
                 */
                res.insert(map.get(r), "(");
                /*
                    重复数字前插入 (
                 */
                res.append(')');
                /*
                    重复即将开始的地方，即当前字符串末端插入 )
                 */
                break;
                /*
                    停止
                 */
            }
            map.put(r, res.length());
            /*
                记录数字及当前字符串长度
             */
            r *= 10;
            /*
                计算下一个位了，余数需要 * 10
             */
            res.append(r / d);
            r %= d;
            /*
                记录新的商 和 余数
             */
        }
        return res.toString();


    }

    public static void main(String[] args) {
        分数到小数 res = new 分数到小数();
//        System.out.println(res.fractionToDecimal(1, 2));
        System.out.println(res.fractionToDecimal(-50, 8));
    }
}
