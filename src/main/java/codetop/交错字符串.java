package codetop;

/**
 * Title: 交错字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-25
 */
public class 交错字符串 {
//    private String s1;
//    private String s2;
//    private String s3;
//    private int len1;
//    private int len2;
//    private int len3;
//    private boolean[][] visited;
//    public boolean isInterleave(String s1, String s2, String s3) {
//        this.s1 = s1;
//        this.s2 = s2;
//        this.s3 = s3;
//        len3 = s3.length();
//        len1 = s1.length();
//        len2 = s2.length();
//        if (len3 != len1 + len2) {
//            return false;
//        }
//        if (len3 == 0 && len1 == 0 && len2 == 0) {
//            return true;
//        }
//        if (len1 == 0) {
//            return s3.equals(s2);
//        }
//        if (len2 == 0) {
//            return s3.equals(s1);
//        }
//        /*
//            提前的长度判断
//         */
//        visited = new boolean[len1 + 1][len2 + 1];
//        /*
//            s1 前 i 个字符
//            与 s1 前 j 个字符
//            是否访问
//
//            如果访问表示之前已经有过相同的情况，剩下的字符拆分会相同
//            直接返回
//
//            len1+1 和 len2+1 是因为忽略 0 下标
//         */
//        return dfs(0, 0, 0);
//    }
//
//    private boolean dfs (int inx1, int inx2,int inx3) {
//        if (inx3 == len3) {
//            return true;
//        }
//        if (visited[inx1][inx2]) {
//            return false;
//        }
//
//        visited[inx1][inx2] = true;
//
//        if (inx1 < len1 && s1.charAt(inx1) == s3.charAt(inx3) &&
//                dfs(inx1 + 1, inx2, inx3 + 1)) {
//            /*
//                如果s1 没访问完，且 s1 的 inx1 字符与 s3 的inx3 字符相同
//                访问后续的，如果也正确则返回
//             */
//            return true;
//        }
//
//        if (inx2 < len2 && s2.charAt(inx2) == s3.charAt(inx3) &&
//                dfs(inx1, inx2 + 1, inx3 + 1)) {
//            /*
//                如果s2 没访问完，且 s2 的 inx2 字符与 s3 的inx3 字符相同
//                访问后续的，如果也正确则返回
//             */
//            return true;
//        }
//        return false;
//
//    }

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
        /*
            同样的长度判断
         */

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        /*
            s1 前 i 个字符与 s2 前 j 个字符能不能构成 s3 前 i + j  个字符
         */
        dp[0][0] = true;

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                int inx3 = i + j - 1;

                if (i > 0) {
                    dp[i][j] = dp[i][j] ||
                            (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(inx3));
                    /*
                        s1当前字符与 s3字符相同
                        比较
                     */
                }

                if (j > 0) {
                    dp[i][j] = dp[i][j] ||
                            (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(inx3));
                }
            }
        }

        return dp[len1][len2];

    }
}
