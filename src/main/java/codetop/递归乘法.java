package codetop;

/**
 * Title: 递归乘法
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-07
 */
public class 递归乘法 {
    public int multiply(int A, int B) {
        if (A > B) {
            /*
                交换，A <= B
                计算次数少
             */
            A = A ^ B;
            B = A ^ B;
            A = A ^ B;
        }
        /*
            A = a0*2^0+a1*2^1+...+a(n)*2^n
            B * A = B * (a0*2^0+a1*2^1+...+a(n)*2^n)
                  = B * a0 * 2^0 + B * a1 * 2^1 + ... + B * a(n) * 2^n

                 a0 - an 为0或者1
                 0时对结果没影响
                 1时需要计算
                 使用左移，右移，取最低位二进制位上的值
         */
        int res = 0;
        for (int i = 0; A != 0; i++) {
            if ((A & 1) == 1) {
                res += B << i;
            }
            A >>>= 1;
        }

        return res;

    }
}
