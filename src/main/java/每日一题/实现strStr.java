package 每日一题;

/**
 * Title: 实现strStr
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-20
 */
public class 实现strStr {
    public int strStr(String haystack, String needle) {
//        int L = needle.length(), n = haystack.length();
//        //字符串长度             匹配串长度
//        if (L == 0) {
//            return 0;
//            //按照题意匹配串长度为0直接返回0
//        }
//        int pn = 0;
//        //字符串指针
//        while (pn < n - L + 1) {
//            //计算字符串指针最大范围
//            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)){
//                ++pn;
//                //排除字符串中pn指针开始的不与匹配串首字母相同的字符
//            }
//            int currLen = 0, pL = 0;
//            //匹配长度          匹配串指针
//            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
//                ++pn;
//                ++pL;
//                ++currLen;
//                //相等则两指针和长度递增
//            }
//            if (currLen == L){
//                return pn - L;
//                //长度同匹配串长度，返回起始坐标
//            }
//            pn = pn - currLen + 1;
//            //不匹配返回上次开始匹配的坐标的下一个
//        }
//        return -1;
//        //没找到返回-1


        int len1 = haystack.length();
        int len2 = needle.length();
        if (len2 == 0) {
            return 0;
        }
        KMP kmp = new KMP(needle);
        return kmp.search(haystack);

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
