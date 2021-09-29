package 每日一题;

/**
 * Title: 两个字符串的删除操作583
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-28
 */
public class 两个字符串的删除操作583 {
//    private int res;
//    public int minDistance(String word1, String word2) {
//        res = word1.length() + word2.length();
//        dfs(word1, 0, word2, 0, 0);
//        return res;
//
//    }
//
//    private void dfs (String word1, int inx1, String word2, int inx2, int count) {
//        if (inx1 == word1.length() && inx2 == word2.length()) {
//            res = Math.min(res, count);
//            return;
//        }
//        if (inx1 == word1.length()) {
//            res = Math.min(res, count + word2.length() - inx2);
//            return;
//        }
//        if (inx2 == word2.length()) {
//            res = Math.min(res, count + word1.length() - inx1);
//            return;
//        }
//        if (word1.charAt(inx1) != word2.charAt(inx2)) {
//            dfs(word1, inx1 + 1, word2, inx2, count + 1);
//            dfs(word1, inx1, word2, inx2 + 1, count + 1);
//        } else {
//            dfs(word1, inx1 + 1, word2, inx2 + 1, count);
//        }
//
//    }

//    public int minDistance(String word1, String word2) {
//        int m = word1.length();
//        int n = word2.length();
//
//        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (word1.charAt(i) == word2.charAt(j)) {
//                    dp[i + 1][j + 1] = dp[i][j] + 1;
//                } else {
//                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
//                }
//            }
//        }
//        return m - dp[m][n] + n - dp[m][n];
//    }


    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int pre = 0;
            for (int j = 0; j < n; j++) {
                int tmp = dp[j + 1];
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[j + 1] = pre + 1;
                } else {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j]);
                }
                pre = tmp;
            }
        }
        return m - dp[n] + n - dp[n];
    }


    public static void main(String[] args) {
        两个字符串的删除操作583 res = new 两个字符串的删除操作583();
        System.out.println(res.minDistance("a", "b"));
        System.out.println(res.minDistance("sea", "eat"));
        System.out.println(res.minDistance("dinitrophenylhydrazine","acetylphenylhydrazine"));
    }
}
