package 每日一题;

import java.util.Map;

/**
 * Title: 最长回文子序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-12
 */
public class 最长回文子序列 {
//    public int longestPalindromeSubseq(String s) {
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            builder.append(s.charAt(i));
//        }
//        String t = builder.reverse().toString();
//        return longestCommonSubsequence(s, t);
//    }
//
//    private int longestCommonSubsequence(String s, String t) {
//        int m = s.length();
//         int n = t.length();
//         //dp定义，s[i - 1]t[j - 1]的最长长度
//         /*因为我们要定义dp的base case 即dp[0][],dp[][0],
//         它们表示空集与该字符串的最长公共子集；
//         在加上长度为length的字符串，
//         所以长度为length+1；
//         即当s长度为0时不管t怎样最长公共子序列都为0，t同理*/
////        int[][] dp = new int[m + 1][n + 1];
//        /*
//        化二维为一维，求的是四宫格右下角的，可以一维代替
//         */
//        int[] dp = new int[n + 1];
//
//        for (int i = 1; i < m + 1; i++) {
//            int pre = 0;
//            for (int j = 1; j < n + 1; j++) {
//                int tmp = dp[j];
//                if (s.charAt(i - 1) == t.charAt(j - 1)) {
////                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                     //当s[i] == t[j]时，最长公共子序列长度等于dp[i-1][j-1]+1
//                    /*
//                        dp[i][j] 四宫格中位于右下角，使用 pre 代替 dp[i - 1][j - 1] 成为左上角
//                     */
//                    dp[j] = pre + 1;
//
//                 } else {
////                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                     //当s[i] != t[j]时，最长公共子序列长度等于dp[i-1][j]或者dp[i][j-1]，
//                     // 不是dp[i-1][j-1]的原因是前两个由这个推导而来，长度大于等于，因此不用计算
//                    dp[j] = Math.max(dp[j - 1], tmp);
//                    /*
//                        dp[i][j] 四宫格中位于右下角，
//                         dp[i - 1][j] 右上角  在进入这层的 i,j 时，tmp 保存了 i-1, j
//                         dp[i][j - 1] 左下角  在进入这层的 i,j 时，dp[j-1] 保存了 i, j-1
//                     */
//                 }
//
//                pre = tmp;
//                /*
//                    tmp 保存了 i-1, j，赋值给 pre，
//                    j++ 之后，相等于 pre = i-1,j-1
//                 */
//             }
//         }
//         return dp[n];
//    }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        /*
            s 的 i 到 j的字符构成的回文子序列长度
            如果 s 的第 i 个字符和第 j 个字符相同的话

            dp[i][j] = dp[i + 1][j - 1] + 2

            如果 s 的第 i 个字符和第 j 个字符不同的话

            f[i][j] = max(f[i + 1][j], f[i][j - 1])

            然后注意遍历顺序，i 从最后一个字符开始往前遍历，
            j 从 i + 1 开始往后遍历，
            这样可以保证每个子问题都已经算好了

            单个字符也是回文串
            dp[i][i]=1

            结果就是返回 dp[0][len - 1]



         */

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }

}
