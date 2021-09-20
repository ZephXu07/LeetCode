package labuladong;

/**
 * Title: labuladong.SuperPow
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-16
 */
public class SuperPow {
    int base = 1337;

    private int mypow(int a, int k) {
        a %= base;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= a;
            res %= base;
        }
        return res;
    }
    private int helper(int a, int[] b, int index) {
        if (index == -1) {
            return 1;
        }
        int last = b[index];

        int part1 = mypow(a, last);
        int part2 = mypow(helper(a, b, index - 1), 10);
        return (part1 * part2) % base;
    }

    public int superPow(int a, int[] b) {
        return helper(a, b, b.length - 1);
    }

    public static void main(String[] args) {
        int a = 2147483647;
        int[] b = {2,0,0};
        int i = new SuperPow().superPow(a, b);
        System.out.println(i);
    }
}
