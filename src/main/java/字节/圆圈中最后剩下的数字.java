package 字节;

/**
 * Title: 圆圈中最后剩下的数字
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-21
 */
public class 圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; ++i) {
            res = (res + m) % i;
        }
        return res;
    }

    public int lastRemaining1(int n, int m) {
        return helper(n, m);
    }
    private int helper(int n, int m) {
        if (n == 0) {
            return 0;
        }
        int x = helper(n - 1, m);
        return (x + m) % n;
    }
}
