package 每日一题;

import java.util.LinkedList;
import java.util.List;

/**
 * Title: 扰乱字符串
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-04-16
 */
public class 扰乱字符串 {
    public boolean isScramble0(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        for (int f : freq) {
            if (f != 0) {
                return false;
            }
        }
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble0(s1.substring(0, i), s2.substring(0, i))
                    && isScramble0(s1.substring(i), s2.substring(i))) {
                return true;
            }

            if (isScramble0(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble0(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }
    //递归，超时


    public boolean isScramble1(String s1, String s2) {
        int len = s1.length();
        //题目说明故省去判断
        boolean[][][] dp = new boolean[len][len][len + 1];
        //s1中i坐标开始的长度为k字符串等于s2中j坐标开始的长度为k的字符串是否是扰乱字符串
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
                //当一个字符时直接判断
            }
        }

        for (int n = 2; n <= len; n++) {
            //dp，最终完整长度需要递增到 len
            for (int i = 0; i <= len - n; i++) {
                //字符串s1开始下标
                for (int j = 0; j <= len - n; j++) {
                    //字符串s2开始下标
                    for (int k = 1; k <= n - 1; k++) {
                        //切开的点，按递归的方法时k的值是前一个串的下一个坐标，是后一个串的坐标起点
                        if (dp[i][j][k] && dp[i + k][j + k][n - k]) {
                            // 第一种情况：S1 -> T1, S2 -> T2
                            //s1切开的i到k - 1的串等于s2切开的j 到 k - 1串
                            //及另一边i + k到n串等于s2的另一边 j + k 到n的串
                            dp[i][j][n] = true;
                            //当s1以i坐标开始的长度n的串等于s2以j坐标开始开始的长度n的串
                            break;
                            //一个相等即s1从i开始长度为n的串可以由s2从j开始的长度n的串扰乱而来，由于是求存在，因此直接返回
                        }


                        // 第二种情况：S1 -> T2, S2 -> T1
                        // S1 起点 i，T2 起点 j + 前面那段长度 n - k 再加切分的长度相等，即前半部分扰乱到后半部分，因此与t2串相比，

                        // S2 起点 i + 前面切分的长度k开始的坐标，T2仍是j开始，长度原为n，切分k之后为n - k
                        if (dp[i][j + n - k][k] && dp[i + k][j][n - k]) {
                            dp[i][j][n] = true;
                            break;
                            //同理情况一
                        }
                    }
                }
            }
        }
        return dp[0][0][len];
        //返回S从0开始长度为len的串是否为T从0开始的长度为len的串的扰乱字符串
    }

}
