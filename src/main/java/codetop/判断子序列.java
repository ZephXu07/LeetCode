package codetop;

/**
 * Title: 判断子序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-08
 */
public class 判断子序列 {
//    public boolean isSubsequence(String s, String t) {
//        /*
//            贪心，双指针，
//            相同则 s 与 t 上指针移动
//            不同则只有 t 上指针移动
//            看最后 s 上的指针是否溢出
//            即全部匹配
//         */
//        int i = 0, j = 0;
//        while (i < s.length() && j < t.length()) {
//            if (s.charAt(i) == t.charAt(j)) {
//                i++;
//            }
//            j++;
//        }
//        return i == s.length();
//    }

    public boolean isSubsequence(String s, String t) {
        int n = t.length();
        int[][] dp = new int[n + 1][26];
        /*
            dp[i][j]
            j 字符在 t 字符串 i 位置以后第一个出现的位置
            如果 j 出现在 i 位置上 dp[i][j] = i   t[i] = j
            如果 j 不是出现在 i 位置上，即出现在 i + 1 以后的位置上，dp[i][j] = d[i + 1][j] t[i] != j

            所以 i 从后往前遍历，
            而对于 i = n - 1 位置而言
            如果 t[i] = j ，dp[n - 1][j] = n - 1
            如果 t[i] != j ,后续没有字符了，所以 dp[n][j] 设为边界，dp[n][j] = n，表示没有这字符
            即 dp[i][j] = n，则表示从位置 i 开始往后不存在字符 j

            所以直接初始化 dp[n][0-25] = n
         */
        for (int i = 0; i < 26; i++) {
            dp[n][i] = n;
        }

        int m  = s.length();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        /*
            s[i] 字符在 t 的 inx 位置后 的位置
            一开始 i == 0 ，如果找到了 s[i] 在 t inx == 0 位置及以后的下标
            则 dp[inx][s.charAt(i) - 'a'] 则是 s[i] 字符的坐标
            于是 s[i+1] 在 t 的位置要从 dp[inx][s.charAt(i) - 'a'] + 1后寻找
            所以 inx = dp[inx][s.charAt(i) - 'a'] + 1，直到遍历完 s
            而如果  dp[inx][s.charAt(i) - 'a'] = n (t 长度)
            则在 inx 位置及以后找不到 s[i] ，所以直接返回 false
         */
        int inx = 0;
        for (int i = 0; i < m; i++) {
            if (dp[inx][s.charAt(i) - 'a'] == n) {
                return false;
            }
            inx = dp[inx][s.charAt(i) - 'a'] + 1;
        }

        return true;
    }

}
