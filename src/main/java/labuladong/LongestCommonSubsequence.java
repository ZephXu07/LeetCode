package labuladong;

/**
 * Title: labuladong.LongestCommonSubsequence
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-20
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        /*因为我们要定义dp的base case 即dp[0][],dp[][0],
        它们表示空集与该字符串的最长公共子集；
        在加上长度为length的字符串，
        所以长度为length+1；*/
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

        String text1 = "bl";
        String text2 ="yby";
        LongestCommonSubsequence res = new LongestCommonSubsequence();
        int ans = res.longestCommonSubsequence(text1, text2);
        System.out.println(ans);
        ans = res.longestCommonSubsequenceOptimized(text1, text2);
        System.out.println(ans);
    }

    public int longestCommonSubsequenceOptimized(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n + 1];
        int tmp;
        for (int i = 1; i < m + 1; i++) {
            int last = 0;
            for (int j = 1; j < n + 1; j++) {
                tmp = dp[j];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = last + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], tmp);
                }
                last = tmp;
            }
        }
        return dp[n];
    }
}
