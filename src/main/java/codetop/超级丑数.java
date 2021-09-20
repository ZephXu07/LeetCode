package codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Title: 超级丑数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-09
 */
public class 超级丑数 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        /*
            类比丑数2 把 2 3 5 换成 primes 数组
            a b c 为指针，指向对应 2 3 5 组成的丑数，即 2 3 5为质数构成的
            所以 pri[] 同理，为指向对应 primes 数组值构成的丑数， 即 primes 数组值为质数构成的

            two three five 2 3 5 组成的丑数，即 2 3 5为质数构成的
            ugl[] primes 数组值构成的丑数， 即 primes 数组值为质数构成的

            每找到一个 2 3 5 构成的丑数，再寻找其上一个对应的 2 3 5指针指向的数
            即用新的丑数再乘 2 3 5 得到下一个丑数

            而 pri[] 指针数组同理
         */
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 1;

        int[] pri = new int[primes.length];
        int[] ugly = primes.clone();
//        int a = 0;
//        int b = 0;
//        int c = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < ugly.length; j++) {
                ugly[j] = dp[pri[j]] * primes[j];
                dp[i] = Math.min(ugly[j], dp[i]);
            }
//            int two = dp[a] * 2;
//            int three = dp[b] * 3;
//            int five = dp[c] * 5;
//            dp[i] = Math.min(Math.min(two, three), five);

            for (int j = 0; j < pri.length; j++) {
                if (dp[i] == ugly[j]) {
                    pri[j]++;
                }
            }
//            if (dp[i] == two) {
//                a ++;
//            }
//            if (dp[i] == three) {
//                b ++;
//            }
//            if (dp[i] == five){
//                c ++;
//            }
        }
        return dp[n - 1];
    }
}
