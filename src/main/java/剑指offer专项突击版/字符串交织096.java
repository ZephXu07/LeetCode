package 剑指offer专项突击版;

/**
 * Title: 字符串交织096
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-04
 */
public class 字符串交织096 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len3 != len1 + len2) {
            return false;
        }
        if (len3 == 0 && len1 == 0 && len2 == 0) {
            return true;
        }
        if (len1 == 0) {
            return s3.equals(s2);
        }
        if (len2 == 0) {
            return s3.equals(s1);
        }

        boolean[] dp = new boolean[len2 + 1];
        dp[0] = true;

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                int inx3 = i + j - 1;

                if (i > 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(inx3);
                }

                if (j > 0) {
                    dp[j] = dp[j] ||
                            (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(inx3));
                }
            }
        }

        return dp[len2];
    }
}
