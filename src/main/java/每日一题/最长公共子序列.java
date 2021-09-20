package 每日一题;

/**
 * Title: 最长公共子序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-03
 */
public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length();
//         int n = text2.length();
//         int[][] dp = new int[m + 1][n + 1];
//         //dp定义，text1[i - 1]text2[j - 1]的最长长度
//         /*因为我们要定义dp的base case 即dp[0][],dp[][0],
//         它们表示空集与该字符串的最长公共子集；
//         在加上长度为length的字符串，
//         所以长度为length+1；
//         即当text1长度为0时不管text2怎样最长公共子序列都为0，text2同理*/
//         for (int i = 1; i < m + 1; i++) {
//             for (int j = 1; j < n + 1; j++) {
//                 if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1] + 1;
//                     //当text[i] == text[j]时，最长公共子序列长度等于dp[i-1][j-1]+1
//                 } else {
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                     //当text[i] == text[j]时，最长公共子序列长度等于dp[i-1][j]或者dp[i][j-1]，
//                     // 不是dp[i-1][j-1]的原因是前两个由这个推导而来，长度大于等于，因此不用计算
//                 }
//             }
//         }
//         return dp[m][n];

        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n + 1];
        //化二维为一维，求的是四宫格右下角的，可以一维代替
        for (int i = 1; i < m + 1; i++) {
            int last = 0;
            for (int j = 1; j < n + 1; j++) {
                int tmp = dp[j];
                //tmp == dp[i - 1][j]，即四宫格右上角角
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = last + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1]/*四宫格左下角*/, tmp);
                }
                last = tmp;
                //dp[i - 1][j - 1]，即四宫格左上角
            }
        }
        return dp[n];

    }
}
