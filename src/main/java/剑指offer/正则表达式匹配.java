package 剑指offer;

/**
 * Title: 正则表达式匹配
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-01
 */
public class 正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        if (null == s || null == p) {
            return false;
        }
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        dp[0][0] = true;
        for (int i = 1; i < pLen + 1; i++) {
            if (pChar[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i < sLen + 1; i++) {
            for (int j = 1; j < pLen + 1; j++) {
                if (sChar[i - 1] == pChar[j - 1] || pChar[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar[j - 1] == '*') {
                    if (sChar[i - 1] == pChar[j - 2] || pChar[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        正则表达式匹配 res = new 正则表达式匹配();
        System.out.println(res.isMatch(s, p));
    }
}
