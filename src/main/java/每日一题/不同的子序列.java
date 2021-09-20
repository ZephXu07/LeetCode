package 每日一题;

/**
 * Title: 不同的子序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-03-17
 */
public class 不同的子序列 {
//    private int[][] memo;
//    public int numDistinct(String s, String t) {
//        int sLen = s.length();
//        int tLen = t.length();
//        if (tLen == 0) {
//            return 1;
//        }
//        if (sLen == 0) {
//            return 0;
//        }
//        memo = new int[sLen][tLen];
//        for (int i = 0; i < sLen; i++) {
//            for (int j = 0; j < tLen; j++) {
//                memo[i][j] = -1;
//            }
//        }
//        helper(s, t, sLen - 1, tLen - 1);
//        return memo[sLen - 1][tLen - 1];
//    }
//
//    private int helper(String s, String t, int sInx, int tInx) {
//        if (tInx < 0) {
//            return 1;
//        }
//        if (sInx < 0) {
//            return 0;
//        }
//        if (memo[sInx][tInx] != -1) {
//            return memo[sInx][tInx];
//        }
//        if (s.charAt(sInx) == t.charAt(tInx)) {
//            memo[sInx][tInx] = helper(s, t,sInx - 1, tInx - 1) + helper(s, t, sInx - 1, tInx);
//        } else {
//            memo[sInx][tInx] = helper(s, t,sInx - 1, tInx);
//        }
//        return memo[sInx][tInx];
//    }




    public static void main(String[] args) {
        不同的子序列 res = new 不同的子序列();
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(res.numDistinct(s, t));
    }

    public int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (tLen == 0) {
            return 1;
        }
        if (sLen == 0) {
            return 0;
        }
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[sLen][tLen];
    }
}
