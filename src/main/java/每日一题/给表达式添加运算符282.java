package 每日一题;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 给表达式添加运算符282
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-16
 */
public class 给表达式添加运算符282 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new LinkedList<>();
        backtrack(res, 0, 0, 0, new StringBuilder(), num, target);
        return res;
    }

    private void backtrack (List<String> res, int inx, long sum, long mul,
                            StringBuilder path, String num, int target) {
        if (inx == num.length()) {
            if (sum == target) {
                res.add(path.toString());
            }
            return;
        }

        int len = path.length();
        /*
            记录开始前的长度
            方便恢复
         */
        if (inx > 0) {
            /*
                当除了第一位不能放置符号外其余均可
                于是先添加字符，避免多余判断
             */
            path.append(' ');
        }

        /*
            sum 是当前的加减的总和，包含 mul 此可能的的左侧乘数
         */

        long val = 0;
        /*
            i == inx 此时 0 也可以
            i != inx 且 num.charAt(inx) == 0 表示出现了数字的前导 0
         */
        for (int i = inx; i < num.length() && (i == inx || num.charAt(inx) != '0'); i++) {
            /*
                枚举一位数字或者多位数字
             */
            val = val * 10 + num.charAt(i) - '0';
            path.append(num.charAt(i));
            if (inx == 0) {
                /*
                    第一位不能有符号
                 */
                backtrack(res, i + 1, val, val, path, num, target);
            } else {
                path.setCharAt(len, '+');
                backtrack(res, i + 1, sum + val, val, path, num, target);
                /*
                    val 作为加法的右侧，先添加到 sum 之中，如果后续一位是 * 乘法，
                    则 val 则作为乘法的左侧数字
                    则在 sum 减去 作为左侧乘数mul 的 val

                 */

                path.setCharAt(len, '-');
                backtrack(res, i + 1, sum - val, -val, path, num, target);
                /*
                    val 作为加法的右侧，先添加到 sum 之中，负数，如果后续一位是 * 乘法，
                    则 val 则作为乘法的左侧数字，为负数
                    则在 sum 减去 作为左侧乘数mul 的 -val，减去一个负数，相当于加一个数，而现在是减，刚好抵消
                 */
                path.setCharAt(len, '*');
                backtrack(res, i + 1, sum - mul + val * mul, mul * val, path, num, target);
                /*
                    乘法则要在 sum 中减去之前的乘法左侧的数，mul * val 作为新的左侧乘法的数
                 */
            }
        }
        path.setLength(len);
        /*
            回溯
         */

    }

    public static void main(String[] args) {
        给表达式添加运算符282 res = new 给表达式添加运算符282();
        res.addOperators("123", 6).forEach(System.out::println);
    }

}
