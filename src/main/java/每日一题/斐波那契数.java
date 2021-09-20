package 每日一题;

/**
 * Title: 斐波那契数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-01-04
 */
public class 斐波那契数 {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

    public static void main(String[] args) {
        斐波那契数 res = new 斐波那契数();
        System.out.println(res.fib(0));
        System.out.println(res.fib(1));
        System.out.println(res.fib(2));
        System.out.println(res.fib(3));
        System.out.println(res.fib(4));
        System.out.println(res.fib(5));
    }
}
