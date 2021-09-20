package 剑指offer;

/**
 * Title: 数值的整数次方
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-01
 */
public class 数值的整数次方 {
    public double myPow(double x, int n) {
        if (0 == x) {
            return 0;
        }
        double res = 1;
        long a = n;
        if (n < 0) {
            x = 1 / x;
            a = -a;
        }
        while (0 != a) {
            if ((a & 1) != 0) {
                res *= x;
            }
            x *= x;
            a /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        数值的整数次方 res = new 数值的整数次方();
        System.out.println(res.myPow(2, -1));
    }
}
