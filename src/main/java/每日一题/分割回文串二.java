package 每日一题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Title: 分割回文串二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-08
 */
public class 分割回文串二 {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] pal = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(pal[i], true);
        }
        for (int i = len - 1; i>= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                pal[i][j] = (s.charAt(i) == s.charAt(j) && pal[i + 1][j - 1]);
            }
        }
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            if (pal[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (pal[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        分割回文串二 res = new 分割回文串二();
        String s = "ababababababababababababcbabababababababababababa";
        int min = res.minCut(s);
        System.out.println(min);
    }
}
