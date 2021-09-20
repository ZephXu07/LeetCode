package 剑指offer;

/**
 * Title: 不用加减乘除做加法
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-06
 */
public class 不用加减乘除做加法 {
    public int add(int a, int b) {
        int carry = 0;
        while (0 != b) {
            carry = a & b << 1;
            //逻辑运算符比移位运算符级别低
            a ^= b;
            b = carry;
        }
        return a;
    }

}
