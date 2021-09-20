package 每日一题;

import labuladong.Solution;

/**
 * Title: 完全平方数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-11
 */
public class 完全平方数 {
    public int numSquares(int n) {
        /*
            dp[i] = val
            平分和为 i 的最小方案数

         */
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            /*
                初始化为理论最大值，即由 1 相加而来
             */
            for (int j = 1; j <= i; j++) {
                /*
                    从 1 遍历到 i，即平方和为 i 的数
                 */
                int tmp = i - j * j;
                if (tmp >= 0) {
                    /*
                        当平方和为 i 大于 j * j，则可由 j * j + 某个数而来，进行大小比较
                     */
                    dp[i] = Math.min(dp[i], dp[tmp] + 1);
                }
            }
        }
        return dp[n];
    }

    public int numSquares1(int n) {
        /*
            dp[i] = val
            平分和为 i 的最小方案数

         */
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            /*
                初始化为理论最大值，即由 1 相加而来
             */
            int limit = (int) Math.sqrt(i);
            for (int j = 1; j <= limit; j++) {
                /*
                    从 1 遍历到 sqrt(i)，即平方和为 i 的数
                 */
                    /*
                        当平方和为 i 大于 j * j，则可由 j * j + 某个数而来，
                        某个数最小为 0 ，则限制 j <= sqrt(i)，进行大小比较
                     */
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public int numSquares2(int n) {
        /*
            数学定理
            https://baike.baidu.com/item/%E5%9B%9B%E5%B9%B3%E6%96%B9%E5%92%8C%E5%AE%9A%E7%90%86

            一个正整数最多是四个正整数的平方和

            当 n = 4^k * (8 * m + 7) 时，则是 4 个正整数的和
            当 n != 4^k * (8 * m + 7) 时，最多是三个
            1时，说明 n 直接由某个数平分而来
            2时，n 是两个数的平分和而来，即有 a^2 + b^2 = n
                列举 a (1<= a<= sqrt(n))，判断 n - a^2 是不是完全平方数
            3是剩下的，另外三种情况都不是，只有 3

         */
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }


    public static void main(String[] args) {
        完全平方数 res = new 完全平方数();
        int n = 13;
        System.out.println(res.numSquares(n));
        System.out.println(res.numSquares1(n));
    }
}
