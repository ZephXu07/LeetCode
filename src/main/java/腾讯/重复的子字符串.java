package 腾讯;

/**
 * Title: 重复的子字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-11
 */
public class 重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        /**

         1.假设字符串有n个子串构成（n>=1）;//假设子串就是它本身，那么n=1;
         2.str.substring(1,str.length() - 1 ) 意思为 去掉str的首字符和尾字符 即去掉第一个s的首字符 和第二个s的尾字符
         3.一个子串至少有一个字符组成，去掉首尾字符，相当于首尾两个子串不完整，还剩下2n-2个子串，（首尾有几个元素不构成
         子串）
         4.如果此时还包含s，即包含n个子串，则2n-2>=n，即n >=2 ,说明s由一个子串重复两次以上构成，所以符合题意
         5.如果此时不包含s，即2n-2<n，即n<2 ,由1知n>=1,因此n=1，说明s由一个子串构成，即不满足条件
         */
        String str = s + s;
//        return str.substring(1, str.length() - 1).contains(s);

        KMP kmp = new KMP(s);
        return kmp.search(str.substring(1, str.length() - 1)) != -1;
    }
}
class KMP {
    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        dp = new int[M][26];
        // base case
        dp[0][pat.charAt(0) - 'a'] = 1;
        // 影子状态 X 初始为 0
        int X = 0;
        // 构建状态转移图（稍改的更紧凑了）
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 26; c++) {
                dp[j][c] = dp[X][c];
            }
            dp[j][pat.charAt(j) - 'a'] = j + 1;
            // 更新影子状态
            X = dp[X][pat.charAt(j) - 'a'];
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        // pat 的初始态为 0
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 计算 pat 的下一个状态
            j = dp[j][txt.charAt(i) - 'a'];
            // 到达终止态，返回结果
            if (j == M){
                return i - M + 1;
            }
        }
        // 没到达终止态，匹配失败
        return -1;
    }
}
