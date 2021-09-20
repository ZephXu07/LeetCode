package 剑指offer;

/**
 * Title: 斐波那契数列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-28
 */
public class 斐波那契数列 {
    public int fib(int n) {
        if (0 == n) {
            return 0;
        }
        if (1 == n) {
            return 1;
        }
        int pre = 1;
        int res = 1;
        int tmp = 0;
        for (int i = 1; i < n; i++) {
            res = (tmp + pre) % 1000000007;
            tmp = pre;
            pre = res;
        }
        return res;
    }

    public static void main(String[] args) {
        斐波那契数列 斐波那契数列 = new 斐波那契数列();
        System.out.println(斐波那契数列.fib(0));
        System.out.println(斐波那契数列.fib(1));
        System.out.println(斐波那契数列.fib(2));
        System.out.println(斐波那契数列.fib(3));
        System.out.println(斐波那契数列.fib(4));
        System.out.println(斐波那契数列.fib(5));
        System.out.println(斐波那契数列.fib(6));
        System.out.println(斐波那契数列.fib(7));
        System.out.println(斐波那契数列.fib(8));
        System.out.println(斐波那契数列.fib(9));
        System.out.println(斐波那契数列.fib(10));
        System.out.println(斐波那契数列.fib(45));


    }
}
