package labuladong;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: labuladong.MinDistance
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-17
 */
public class MinDistance {
//    private Map<String, Integer> memo = new HashMap<>();
//    private String word1;
//    private String word2;
//    public int minDistance(String word1, String word2) {
//        this.word1 = word1;
//        this.word2 = word2;
//        return dp(this.word1.length() - 1, this.word2.length() - 1);
//    }
//
//    private int dp(int i, int j) {
//        if (i == -1 || j == -1) {
//            return i == -1 ? j + 1 : i + 1;
//        }
//        String key = i + "_" + j;
//        if (memo.containsKey(key)) {
//            return memo.get(key);
//        }
//        if (word1.charAt(i) == word2.charAt(j)) {
//            memo.put(key, dp(i - 1, j - 1));
//        } else {
//            memo.put(key, getMinimum(dp(i, j - 1),
//                                        dp(i - 1, j),
//                                            dp(i - 1, j - 1))
//                                                                    + 1);
//        }
//        return memo.get(key);
//    }
//

//    public int minDistance(String word1, String word2) {
//        int m = word1.length();
//        int n = word2.length();
//        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 1; i <= m; i++) {
//            dp[i][0] = i;
//        }
//        for (int i = 1; i <= n; i++) {
//            dp[0][i] = i;
//        }
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = getMinimum(dp[i][j - 1],
//                                            dp[i - 1][j],
//                                            dp[i - 1][j - 1]) + 1;
//                }
//            }
//        }
//        return dp[m][n];
//    }
    private int getMinimum(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }


}
