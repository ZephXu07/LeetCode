package labuladong;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: labuladong.IsMatch
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-27
 */
public class IsMatch {
    private Map<int[], Boolean> memo = new HashMap<>();

    public boolean isMatch(String s, String p) {
        return dp(0, 0, s, p);
    }

    private boolean dp(int i, int j, String s, String p) {
        if (memo.containsKey(new int[]{i, j})) {
            return memo.get(new int[]{i, j});
        }
        if (j == p.length()) {
            return i == s.length();
        }
        boolean first = i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
        boolean ans;
        if (j <= p.length() - 2 && p.charAt(j + 1) == '*') {
            ans = dp(i, j + 2, s, p) || (first && dp(i + 1, j, s, p));
        } else {
            ans = first && dp(i + 1, j + 1, s, p);
        }
        memo.put(new int[]{i, j}, ans);
        return ans;
    }

    public static void main(String[] args) {
        IsMatch res = new IsMatch();
        long t1 = System.currentTimeMillis();
        System.out.println(res.isMatchDp("aa", "a*"));
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    private boolean isMatchDp(String s, String p) {
        if (null == s || p == null) {
            return false;
        }
        System.out.println(s.charAt(0));
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 1; i < pLen + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i < sLen + 1; i++) {
            for (int j = 1; j < pLen + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] ||  dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[sLen][pLen];
    }
}
