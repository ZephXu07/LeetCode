package 每日一题;

/**
 * Title: 颠倒二进制位
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-29
 */
public class 颠倒二进制位 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            res |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        /*
         * 32位右移，等于0即已经不用运算了
         *  n & 1得到最后一位的二进制位 1 --> (31)...0001 得到1
         *
         * 因为是颠倒，所以 res 再左移 31 - i 位
         * | 或运算，0 | 1 = 1， 1 | 1 = 1，
         *
         * java有符号整数
         * 逻辑右移，最高位补0
         */
        return res;
    }
}
