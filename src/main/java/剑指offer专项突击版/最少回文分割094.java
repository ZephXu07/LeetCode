package 剑指offer专项突击版;

import java.util.Arrays;

/**
 * Title: 最少回文分割094
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-10-03
 */
public class 最少回文分割094 {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] pal = new boolean[len][len];
        /*
            pal[i][j]
            s[i, j] 是不是回文串
         */
        for (int i = 0; i < len; i++) {
            Arrays.fill(pal[i], true);
            /*
                i > j 时是空串，也是回文串
                i == j 时是单字符，也是回文串
             */
        }
        for (int i = len - 1; i>= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                /*
                    i < j
                    s[i,j]
                    当 s[i] == s[j] 且 s[i+1,j-1] 是回文串时 s[i,j] 才是回文串
                    所以遍历顺序从后开始
                 */
                pal[i][j] = (s.charAt(i) == s.charAt(j) && pal[i + 1][j - 1]);
            }
        }
        int[] dp = new int[len];
        /*
            s[0,i] 切割为回文子串的最少切割次数
         */
        Arrays.fill(dp, Integer.MAX_VALUE);
        /*
            初始化为最大最大
         */
        for (int i = 0; i < len; i++) {
            if (pal[0][i]) {
                /*
                    s[0,i] 是回文串，不用分割
                    次数为 0
                 */
                dp[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    /*
                        s[0,i] 不是回文串
                        在 [0,i] 中切割一个 j
                        如果 s[j+1,i] 是回文串
                        则 s[0,j] 切割为回文串即可，次数增加一次
                        所以在比较中寻找最小的
                     */
                    if (pal[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[len - 1];
    }
}
