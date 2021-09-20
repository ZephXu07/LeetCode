package codetop;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Title: 单词拆分II
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-09
 */
public class 单词拆分II {
    public List<String> wordBreak(String s, List<String> wordDict) {
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
        if (!dp[len]) {
            /*
                如果以第 len 字符结尾的字符串不能拆分，
                直接返回空
             */
            return new LinkedList<>();
        }
        LinkedList<String> track = new LinkedList<>();
        List<String> res = new LinkedList<>();
        backtrack(set, track, s, len, dp, res);
        return res;
    }

    private void backtrack(Set<String> set, LinkedList<String> track,
                           String s, int len, boolean[] dp, List<String> res) {
        /*
            枚举字符串的结尾是否可以作为一个单词拆分
            结尾一个字符，结尾及前面两个字符......等等
            可以拆分则拆分，新的结尾是i(不包括)，从右到左枚举
            后续不能则回溯
            当枚举的结尾到达了 0 ，表示已经结束了

            重点是添加在前面，因为是从后向前枚举的
         */
        if (len == 0) {
            StringBuilder builder = new StringBuilder(track.get(0));
            for (int i = 1; i < track.size(); i++) {
                builder.append(' ').append(track.get(i));
            }
            res.add(builder.toString());
            return;
        }

        for (int i = len - 1; i >= 0; i--) {
            String suffix = s.substring(i, len);
            if (set.contains(suffix) && dp[i]) {
                track.addFirst(suffix);
                backtrack(set, track, s, i, dp, res);
                track.removeFirst();
            }
        }
    }

}
