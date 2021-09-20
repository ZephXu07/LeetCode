package codetop;

/**
 * Title: Pow_x_n
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-07-11
 */
public class Pow_x_n {

    public double myPow(double x, int n) {
        return n >= 0 ? quickPow(x, n) : 1 / quickPow(x, -n);
    }
//
//    private double quickPow (double x, int n) {
//    /*
//            快速幂，递归
//            x ^ 77
//                x^2-->x^4-->x^8 * x -->x^18 * x -->x^38 -->x^76 * x
//            x ^ 64
//                x^2 -->x^4 -->x^8 -->x^16 -->x^32 -->x^64
//         */
//        if (n == 0) {
//            return 1.0;
//        }
//        double y = quickPow(x, n / 2);
//        return n % 2 == 0 ? y * y : y * y * x;
//    }

    public double quickPow(double x, int n) {
        /*
            n先化为二进制数，即有
            n = i * 2^0 + i * 2^1 + ... + i * 2^k
            i 为二进制位上的 0 或者 1

            x^n = x^(i * 2^1 + i * 2^2 + ... + i * 2^k)
                = x^(i * 2^1) * ... x^(i * 2^k)
            同理 i 为二进制位上的 0 或者 1
            如果 i == 0，此时 x^(i * 2^k) = 1，对乘积没有任何改变
            如果 i == 1，则做出了贡献

            于是从低位算起，如果 n 的此位上值为 0 ，则答案乘以 x^k

         */
        double res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n /= 2;
        }
        return res;
    }

}
