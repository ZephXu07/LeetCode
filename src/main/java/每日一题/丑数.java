package 每日一题;

/**
 * Title: 丑数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-10
 */
public class 丑数 {
    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        int[] factor = {2, 3, 5};
        for (int f : factor) {
            while (n % f == 0) {
                n /= f;
            }
        }
        return n == 1;
    }
}
