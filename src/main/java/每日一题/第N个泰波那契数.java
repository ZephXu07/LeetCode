package 每日一题;

/**
 * Title: 第N个泰波那契数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-08
 */
public class 第N个泰波那契数 {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int zero = 0;
        int one = 1;
        int two = 1;

        int res = 0;
        while (n > 2) {
            res = zero + one + two;
            zero = one;
            one = two;
            two = res;
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        第N个泰波那契数 res = new 第N个泰波那契数();
        System.out.println(res.tribonacci(4));
        System.out.println(res.tribonacci(25));
    }
}
