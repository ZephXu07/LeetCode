package codetop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Title: 单词拆分
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-18
 */
public class 单词拆分 {
//    private String s;
//    private Set<String> set;
//    private int[] memo;
//    public boolean wordBreak(String s, List<String> wordDict) {
//        this.s = s;
//        set = new HashSet<>(wordDict);
//        /*
//            单词的哈希表
//         */
//        memo = new int[s.length()];
//        /*
//            inx 开始的字符串是否可以拆成相应单词
//            未搜索 0
//            失败 1
//            成功 2
//         */
//        boolean res = dfs(0);
//        return res;
//    }
//
//    private boolean dfs (int inx) {
//        if (inx == s.length()) {
//            /*
//                搜索完，返回成功
//             */
//            return true;
//        }
//        if (memo[inx] != 0) {
//            /*
//                已经搜索，返回成功 2 或失败 1
//             */
//            return memo[inx] == 2;
//        }
//
//        for (int i = inx + 1; i <= s.length(); i++) {
//            String tmp = s.substring(inx, i);
//            /*
//                截取 [inx, i) 判断是否是单词，
//                是的话进入下一层，否则延长长度继续
//             */
//            if (set.contains(tmp) && dfs(i)) {
//                /*
//                    当前出现单词及后续也可以出现单词，
//                    当前位置开始的字符串为 2
//                 */
//                memo[inx] = 2;
//                return true;
//            }
//        }
//        memo[inx] = 1;
//        /*
//            当前开始的字符串不能拆分单词，1
//         */
//        return memo[inx] == 2;
//    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        /*
            第 i 个字符结尾的串是否可以拆分
         */
        dp[0] = true;
        /*
            空字符是true，空属于空
         */
        for (int i = 1; i <= len; i++) {
            if (dp[i]) {
                continue;
            }
            /*
                第 i 个字符结尾的已经可以拆分了
                不用再在字符串下标[0,i)拆分
             */
            for (int j = i - 1; j >= 0; j--) {
                /*
                    在字符串下标[0,i)拆分 [0,j)[j,i)
                 */
                if (!dp[j]) {
                    /*
                        如果 [0,j) 不可以拆分
                        直接 j++，看看[0,j+1)
                     */
                    continue;
                }
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                    /*
                        [0,j) 可以拆分，[j,i)也可以拆分
                        即 dp[i] = true
                        i 个字符结尾的字符串可以拆分，直接结束，
                        看看 i + 1 是否可以拆分
                     */
                }
            }
        }
        return dp[len];
        /*
            第 len 字符结尾是否可以拆分
         */
    }


    public static void main(String[] args) {
        单词拆分 res = new 单词拆分();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("aa");
        wordDict.add("aaa");
        wordDict.add("aaaa");
        wordDict.add("aaaaa");
        wordDict.add("aaaaaa");
        wordDict.add("aaaaaaa");
        wordDict.add("aaaaaaaa");
        wordDict.add("aaaaaaaaa");
        wordDict.add("aaaaaaaaaa");

        System.out.println(res.wordBreak(s, wordDict));
    }
}
