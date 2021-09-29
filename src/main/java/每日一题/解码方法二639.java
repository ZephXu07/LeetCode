package 每日一题;

/**
 * Title: 解码方法二639
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-28
 */
public class 解码方法二639 {
//    public int numDecodings(String s) {
//        /*
//            一位数的情况
//            两位数的情况
//            加法原理
//            乘法原理
//
//            one 一位数
//                s[i] = *
//                    当前有 9 种情况，dp[i-1] * 9 = dp[i]
//                s[i] = [1,9]
//                    当前只有 1 种情况，dp[i-1] = dp[i]
//                s[i] = 0
//                    当前情况不成立，只能作为两位数时的 10 或 20 解码
//                    dp[i] = 0
//            two 两位数，此时至少是两个字符
//                s[i - 1] = *, s[i] = *
//                    [11-19][21-26] 共 15 种情况，dp[i] = dp[i - 2] * 15
//                s[i] = *
//                    s[i-1] = 1，即 [11-19] 9种情况，dp[i] = dp[i - 2] * 9
//                    s[i-1] = 2，即 [21-26] 6种情况，dp[i] = dp[i - 2] * 6
//                    s[i-1] = 0，没有 01-09 的组合, 0 种情况
//                s[i-1] = *
//                    s[i] = [0,6] * 可以取[1,2] 两种情况，dp[i] = dp[i - 2] * 2
//                    s[i] = [7,9] * 只能取[1]，一种情况, dp[i] = dp[i - 2]
//               s[i-1] != 0 且 s[i-1]s[i] <= 26，一种情况，dp[i] = dp[i - 2]
//               其他情况不成立，dp[i] = 0
//
//            一位数的情况 one
//            两位数的情况 two
//            dp[i] = one + two
//            同时同余定理与溢出处理
//
//         */
//        int mod = 1000000007;
//        int len = s.length();
//        long[] dp = new long[len + 1];
//        dp[0] = 1;
//
//        for (int i = 1; i <= len; i++) {
//            char cur = s.charAt(i - 1);
//            long one;
//            if (cur == '*') {
//                one = dp[i - 1] * 9;
//            } else if (cur == '0') {
//                one = 0;
//            } else {
//                one = dp[i - 1];
//            }
//            one %= mod;
//
//            long two = 0;
//            if (i >= 2) {
//                char pre = s.charAt(i - 2);
//                if (cur == '*' && pre == '*') {
//                    two = dp[i - 2] * 15;
//                } else if (cur == '*') {
//                    if (pre == '1') {
//                        two = dp[i - 2] * 9;
//                    } else if (pre == '2') {
//                        two = dp[i - 2] * 6;
//                    }
//                } else if (pre == '*') {
//                    if ('0' <= cur && cur <= '6') {
//                        two = dp[i - 2] * 2;
//                    } else {
//                        two = dp[i - 2];
//                    }
//                } else {
//                    if (pre != '0' && (pre - '0') * 10 + (cur - '0') <= 26) {
//                        two = dp[i - 2];
//                    }
//                }
//            }
//            two %= mod;
//            dp[i] = (one + two) % mod;
//
//        }
//
//
//        return (int)dp[len];
//    }

    public int numDecodings(String s) {
        /*
            一位数的情况
            两位数的情况
            加法原理
            乘法原理

            one 一位数
                s[i] = *
                    当前有 9 种情况，dp[i-1] * 9 = dp[i]
                s[i] = [1,9]
                    当前只有 1 种情况，dp[i-1] = dp[i]
                s[i] = 0
                    当前情况不成立，只能作为两位数时的 10 或 20 解码
                    dp[i] = 0
            two 两位数，此时至少是两个字符
                s[i - 1] = *, s[i] = *
                    [11-19][21-26] 共 15 种情况，dp[i] = dp[i - 2] * 15
                s[i] = *
                    s[i-1] = 1，即 [11-19] 9种情况，dp[i] = dp[i - 2] * 9
                    s[i-1] = 2，即 [21-26] 6种情况，dp[i] = dp[i - 2] * 6
                    s[i-1] = 0，没有 01-09 的组合, 0 种情况
                s[i-1] = *
                    s[i] = [0,6] * 可以取[1,2] 两种情况，dp[i] = dp[i - 2] * 2
                    s[i] = [7,9] * 只能取[1]，一种情况, dp[i] = dp[i - 2]
               s[i-1] != 0 且 s[i-1]s[i] <= 26，一种情况，dp[i] = dp[i - 2]
               其他情况不成立，dp[i] = 0

            一位数的情况 one
            两位数的情况 two
            dp[i] = one + two
            同时同余定理与溢出处理

            从头到尾只使用了三个数不断计算，因此取余 3
         */
        int mod = 1000000007;
        int len = s.length();
        long[] dp = new long[3];
        dp[0] = 1;

        for (int i = 1; i <= len; i++) {
            char cur = s.charAt(i - 1);
            long one;
            if (cur == '*') {
                one = dp[(i - 1) % 3] * 9;
            } else if (cur == '0') {
                one = 0;
            } else {
                one = dp[(i - 1) % 3];
            }
            one %= mod;

            long two = 0;
            if (i >= 2) {
                char pre = s.charAt(i - 2);
                if (cur == '*' && pre == '*') {
                    two = dp[(i - 2) % 3] * 15;
                } else if (cur == '*') {
                    if (pre == '1') {
                        two = dp[(i - 2) % 3] * 9;
                    } else if (pre == '2') {
                        two = dp[(i - 2) % 3] * 6;
                    }
                } else if (pre == '*') {
                    if ('0' <= cur && cur <= '6') {
                        two = dp[(i - 2) % 3] * 2;
                    } else {
                        two = dp[(i - 2) % 3];
                    }
                } else {
                    if (pre != '0' && (pre - '0') * 10 + (cur - '0') <= 26) {
                        two = dp[(i - 2) % 3];
                    }
                }
            }
            two %= mod;
            dp[i % 3] = (one + two) % mod;

        }


        return (int)dp[len % 3];
    }


    public static void main(String[] args) {
        解码方法二639 res = new 解码方法二639();
        System.out.println(res.numDecodings( "*"));
        System.out.println(res.numDecodings("1*"));
        System.out.println(res.numDecodings("2*"));
        System.out.println(196465252);
        System.out.println(res.numDecodings("7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*"));
    }
}
