package codetop;

/**
 * Title: 整数拆分
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-29
 */
public class 整数拆分 {
//    public int integerBreak(int n) {
//        if (0 == n || 1 == n) {
//            return 0;
//        }
//        if (2 == n) {
//            return 1;
//        }
//        int[] dp = new int[n + 1];
//        /*
//            长度为 i 的切割后最大乘积
//            当长度为 i 时，如果切出了 j
//            此时剩下了 i-j，继续 j * dp[i-j]
//                        停止 j * (i-j)
//            由定义取最大
//
//            由 j 取 0 无意义，取 i 页无意义，
//            所以 (0,i)
//
//         */
//        for (int i = 3; i <= n; i++) {
//            for (int j = 1; j < i; j++) {
//                dp[i] = Math.max(dp[i], Math.max((i - j),dp[i - j]) * j);
//            }
//        }
//        return dp[n];
//    }

    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int b = n % 3;
        int a = n / 3;

        if (b == 0) {
            return (int) Math.pow(3, a);
        } else if (b == 1) {
            return (int) (Math.pow(3, a - 1) * 4);
        } else {
            return (int) Math.pow(3, a) * 2;
        }


    }
}
