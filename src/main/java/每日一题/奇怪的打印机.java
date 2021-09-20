package 每日一题;

/**
 * Title: 奇怪的打印机
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-24
 */
public class 奇怪的打印机 {
    public int strangePrinter(String s) {
        /*
            a       打印一次
            aa      打印一次
            ab      打印两次
            aba     打印两次
            abaa    打印两次
            abab    打印三次

            当首尾相同时，可以从低一层转移而来，如
            aa --> a->aa            a转移，一次
            aba --> aaa->aba        ab转移，两次
            abaa --> aaaa->abaa     aba转移，两次

            首尾不同
            ab --> a + b            两次
            abab --> a + bab，ab + ab， aba + b中的次数选择最小的
                    1 + 2，   2 + 2，   2 + 1         三次

            dp[i][j]
            s中第 i 位 到 第 j 位的字符的需要打印的长度
            初始条件，一个字符只需要打印一次 dp[i][i] = 1
            初始赋值不能为 0 ，再题目限制是长度 100，无论怎么打印，次数最多也是100，所以初始化为 101
         */


        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = 101;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }

        return dp[0][len - 1];
    }
}
