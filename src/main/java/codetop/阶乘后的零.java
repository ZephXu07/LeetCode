package codetop;

/**
 * Title: 阶乘后的零
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-29
 */
public class 阶乘后的零 {
    public int trailingZeroes(int n) {
        /*
            10 就有一个 0
            2 * 5 就一个 10
            每个偶数都有多少个 2
            所以只需要考虑 5
            每 5 个数就有一个 5
            每 25 个数就有 5 个 5
            所以
            res = n / 5 + n / 25 + n / 125 + ...
         */
        int res = 0;
        while (n != 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
