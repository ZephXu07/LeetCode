package codetop;

/**
 * Title: 正则表达式匹配
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-01
 */
public class 正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        /*
            s 的前 i 个字符与 p 的前 j 个字符是否匹配
            (1下标 开始）
        */
        dp[0][0] = true;
        /*
            当 s 提供 null ，p 提供 null 时自然匹配
         */

        for (int i = 2; i <= n; i += 2) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
            /*
               s：（空）
               p：a*b*c*
               * 使前一个字符出现 0 此，即 p：（空）
             */
        }

        /*
            i [1,m] j [1,n] dp数组下标原因
         */
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                        /*
                            s[i-1] == p[j - 3]
                           所以 * 使前一个字符次数为 0

                         */
                    } else if ((p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2))
                            && dp[i - 1][j]) {
                        dp[i][j] = true;
                        /*
                            '.' 可以匹配任意字符，相当于 s[i-1] == p[j-2]
                            而 p[j-1]='*'
                            匹配 0 次
                                dp[i][j] = dp[i][j-2]
                            匹配 1 次
                                dp[i][j] = dp[i - 1][j - 2] && (s[i - 1] == p[j - 2])
                                dp[i - 1][j - 2] = dp[i - 1][j]，
                                相对于 dp[i - 1][j - 2] 来说，这里的 *(也就是 p[j - 1]) 匹配了 0 次
                            合并为
                                dp[i][j] = (dp[i - 1][j]) && (s[i - 1] == p[j - 2])
                            依次类推，将将匹配 n 次可以看作为由进行了 n 次的 "匹配 1 次" 的操作，则可以得到：
                            dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && s[i - 1] == p[j - 2])
                         */
                    }

                } else {
                    if (dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) {
                        /*
                            s[i-1] == p[j-1] 且 s[0,i) == p[0,j)
                         */
                        dp[i][j] = true;
                    } else if (dp[i - 1][j - 1] && p.charAt(j - 1) == '.')  {
                        /*
                            虽然 s[i-1] != p[j-1] ,但 '.' 可以匹配任意字符
                            再  s[0,i) == p[0,j)
                         */
                        dp[i][j] = true;
                    }
                }
            }

        }
        return dp[m][n];




    }
}
