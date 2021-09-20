package codetop;

/**
 * Title: 通配符匹配
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-21
 */
public class 通配符匹配 {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        /*
            s 的前 i - 1 个字符与 p 的前 j - 1 个字符是否匹配
            第 i - 1 个字符与第 j - 1 个字符相同时
            dp[i][j] = dp[i - 1][j - 1]

            如果 p 的第 j - 1 个字符是 'j'，能代替任何个字母
            dp[i][j] = dp[i - 1][j - 1]

            如果 p 的第 j - 1个字符是 '*'
                如果忽略它，dp[i][j] = dp[i][j-1]
                如果使用它，就要看情况，看其前面 s [0,i-1] 与 p [j - 1] 是否有一个相同，
                        相同了 * 则可以使用 n 次直到 j - 1 - 1 字符（同时 j 字符 '*' 也可以再使用）
                    dp[i][j] = dp[i-1][j-1] || dp[i-2][j-1] || ... || dp[0][j-1] (1)
                 而同时处理 i - 1 字符时
                    dp[i-1][j] = dp[i-2][j-1] || dp[i-3][j-1] || ... || dp[0][j-1] (2)
                  等价代替
                    dp[i][j] = dp[i-1][j]

             于是忽略与使用时
                dp[i][j] = dp[i][j-1] || dp[i-1][j]

              忽略：ac 与 ac*  dp[i][j] = dp[i][j-1]
              dp[2][3] = dp[2][2] 即 ac == ac
              使用：acfun 与 ac* dp[i][j] = dp[i-1][j]
              dp[3][3] = dp[2][3] acf == ac*
              dp[4][3] = dp[3][3] acfu == ac*
              dp[5][3] = d[4][3] acfun == ac*


              初始化 s 的空字符串与 p 的空字符串可以相互匹配 dp[0][0] = true
               而当有一方是空时另一方无论长度多少都是 false

              但是同时当 s 是空字符时，p 如果前 j - 1 字符都是 *，即 * 号全部取空字符
              则 dp[0][j] = true，后面则不是了，


         */
        dp[0][0] = true;

        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[sLen][pLen];
    }
}
