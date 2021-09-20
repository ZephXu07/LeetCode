package codetop;

/**
 * Title: 不同的子序列
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-15
 */
public class 不同的子序列 {

//     public int numDistinct(String s, String t) {
//         int sLen = s.length();
//         int tLen = t.length();
//         /*
//            t 为空时是 s 的子序列
//            且只有一个
//          */
//         if (tLen == 0) {
//             return 1;
//         }
//         if (sLen == 0) {
//             /*
//                s 为空自然没有
//              */
//             return 0;
//         }
//         int[][] memo = new int[sLen][tLen];
//         for (int i = 0; i < sLen; i++) {
//             for (int j = 0; j < tLen; j++) {
//                 /*
//                    备忘录的初始化
//                    s[0,i] 的子序列中有多少个 t[0,j]
//                  */
//                 memo[i][j] = -1;
//             }
//         }
//         dfs(s, t, sLen - 1, tLen - 1, memo);
//         return memo[sLen - 1][tLen - 1];
//     }
//
//     private int dfs(String s, String t, int sInx, int tInx, int[][] memo) {
//         /*
//            t 匹配完了，说明在 s 中找到了
//          */
//         if (tInx < 0) {
//             return 1;
//         }
//         /*
//            到这里 t 还没有匹配完，但 s 遍历完了
//            说明找不到
//          */
//         if (sInx < 0) {
//             return 0;
//         }
//         if (memo[sInx][tInx] != -1) {
//             /*
//                已经遍历过  s[0,sInx] 的子序列中有多少个 t[0,tInx]
//                直接返回
//              */
//             return memo[sInx][tInx];
//         }
//         if (s.charAt(sInx) == t.charAt(tInx)) {
//             /*
//                s[sInx] == t[tInx]
//                在 s 中找到了 t 的一个字符
//                可进行选择匹配，同时看后续的字符
//                也可在 s 中忽略此字符，遍历下一个
//              */
//             memo[sInx][tInx] = dfs(s, t,sInx - 1, tInx - 1, memo) + dfs(s, t, sInx - 1, tInx, memo);
//         } else {
//             /*
//                s[sInx] != t[tInx]
//                自然遍历 s 的下一个字符
//              */
//             memo[sInx][tInx] = dfs(s, t,sInx - 1, tInx, memo);
//         }
//         return memo[sInx][tInx];
//     }
    public int numDistinct(String s, String t) {
    int sLen = s.length();
    int tLen = t.length();
    if (tLen == 0) {
        /*
            t 为空时是 s 的子序列
            且只有一个
          */
        return 1;
    }
    if (sLen == 0) {
        /*
            到这里 t 还没有匹配完，但 s 遍历完了
            说明找不到
          */
        return 0;
    }
    int[][] dp = new int[sLen + 1][tLen + 1];
    /*
        dp[i][j]
        s [0,i - 1] 可以构成 t[0,j-1] 的子序列有多少
     */
    for (int i = 0; i <= sLen; i++) {
        /*
            当 t 为 null 时，s[0] - s[0,len-1] 均可以构成 t，但只有一个
         */
        dp[i][0] = 1;
    }
    for (int i = 1; i <= sLen; i++) {
        for (int j = 1; j <= tLen; j++) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                /*
                    当 s[i-1] == t[j-1] 时，s[0,i-2] 能构成多少个 t[0,j-2]，再加上新的这个
                    或者忽略这个 s[i-1] ，看 s[0,i-2] 能构成多少个 t[0,j-1]
                 */
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            } else {
                /*
                    当 s[i-1] ！= t[j-1] 时
                    看s[i-1] ，看 s[0,i-2] 能构成多少个 t[0,j-1]
                 */
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    return dp[sLen][tLen];
    /*
        返回 s[0,sLen-1] 能构成多少个 t[0,tLen-1]
        即 s 中有多少个子序列为 t
     */
}


}
