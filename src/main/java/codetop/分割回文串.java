package codetop;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 分割回文串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-09
 */
public class 分割回文串 {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        /*
            dp[i][j]
            s 的 [i,j] 是否回文串
            s 的 [i,i] 单字符必是回文串
            如果 s[i] == s[j] 则要看 dp[i+1,j-1]
            即 dp[i][j] = (s[i] == s[j]) && dp[i+1,j-1]
            所以从后面遍历

            回溯时根据 dp[i][j] 判断哪里可以切割
         */
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (i == j) || ((dp[i + 1][j - 1] || j - i == 1) && s.charAt(i) == s.charAt(j));
                /*
                    i == j，长度为 1 自然是
                    而当 s.charAt(i) == s.charAt(j)则要看其他
                    j - i = 1，表示长度为 3 ，或者 [i+1,j-1] 时符号即dp[i + 1][j - 1] = true
                 */
            }
        }
        List<List<String>> res = new LinkedList<>();
        List<String> track = new LinkedList<>();
        backtrack(s, res, track, 0, n, dp);
        return res;
    }

    private void backtrack (String s, List<List<String>> res, List<String> track, int inx, int n, boolean[][] dp) {
        if (inx == n) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int j = inx; j < n; j++) {
            if (dp[inx][j]) {
                track.add(s.substring(inx, j + 1));
                backtrack(s, res, track, j + 1, n, dp);
                track.remove(track.size() - 1);
            }
        }
    }
}
