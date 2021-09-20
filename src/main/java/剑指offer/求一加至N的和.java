package 剑指offer;

/**
 * Title: 求一加至N的和
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-08
 */
public class 求一加至N的和 {
    public int sumNums(int n) {
        boolean res = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public int sumNumsMentallyDisabled(int n) {
        int ans = 0, A = n, B = n + 1;
        boolean flag;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        return ans >> 1;
    }

    int[] test = new int[]{0};
    public int sumNumsTreCatch(int n) {
        try{
            return test[n];
        }catch(Exception e){
            return n+sumNums(n-1);
        }
    }

    public static void main(String[] args) {
        求一加至N的和 res = new 求一加至N的和();
        int n = 10000;
        long t1 = System.currentTimeMillis();
        System.out.println(n * (n + 1) / 2);
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
        long t3 = System.currentTimeMillis();
        System.out.println(res.sumNums(n));
        long t4 = System.currentTimeMillis();
        System.out.println(t4 - t3);
        long t5 = System.currentTimeMillis();
        System.out.println(res.sumNumsMentallyDisabled(n));
        long t6 = System.currentTimeMillis();
        System.out.println(t6 - t5);
        long t7 = System.currentTimeMillis();
        System.out.println(res.sumNumsTreCatch(n));
        long t8 = System.currentTimeMillis();
        System.out.println(t8 - t7);
    }
}
