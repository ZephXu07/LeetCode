package 杂类;

/**
 * Title: 编辑距离72
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-18
 */
public class 编辑距离72 {
//    public int minDistance(String word1, String word2) {
//        int m = word1.length();
//        int n = word2.length();
//        int[][] dp = new int[m + 1][n + 1];
//        /*
//            w1[i - 1] 构成 w2[j - 1] 的最少次数
//            当 w2[j] 为 null 时次数等于 w1[i - 1]下标 (i-1) + 1 = i
//            同理 w1[i]
//            而 w1 w2 为 null 时，dp[0][0] = 0
//         */
//        for (int i = 1; i <= m; i++) {
//            dp[i][0] = i;
//        }
//        for (int i = 1; i <= n; i++) {
//            dp[0][i] = i;
//        }
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    /*
//                        w1[i-1] == w2[j-1]
//                        看 w1[0，i-2] w2[0, j - 2]
//                        即 dp[i - 1][j - 1];
//                     */
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else {
//                    /*
//                        w1[i-1] != w2[j-1]
//                        对 w1 操作
//                        当 w1[0, i-1] 操作后 == w2[0,j-2] 时，对 w1 进行插入操作，补充 == w2[j-1]
//                        当 w1[0, i-2] 操作后 == w2[0,j-1] 时，对 w1 进行删除操作，删除 w1[i-1]
//                        当 w1[0, i-2] 操作后 == w2[0,j-2] 时，改变 w1[i - 1] == w2[j-1]
//                     */
//                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]),
//                            dp[i - 1][j - 1]) + 1;
//                }
//            }
//        }
//        return dp[m][n];
//    }


}
