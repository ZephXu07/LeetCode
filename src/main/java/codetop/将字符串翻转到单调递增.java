package codetop;

/**
 * Title: 将字符串翻转到单调递增
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-23
 */
public class 将字符串翻转到单调递增 {
//    private int res;
//    public int minFlipsMonoIncr(String s) {
//        res = s.length();
//        char[] ch = s.toCharArray();
//        if (ch[s.length() - 1] == '1') {
//            backtrack(s.length() - 2, 0, ch);
//            ch[s.length() - 1] = '0';
//            backtrack(s.length() - 2, 1, ch);
//        } else {
//            backtrack(s.length() - 2, 0, ch);
//            ch[s.length() - 1] = '1';
//            backtrack(s.length() - 2, 1, ch);
//        }
//        return res;
//    }
//
//    private void backtrack (int cur, int count, char[] ch) {
//        if (cur == -1) {
//            res = Math.min(count, res);
//            return;
//        }
//        if (ch[cur + 1] == '1') {
//            if (ch[cur] == '1') {
//                backtrack(cur - 1, count, ch);
//            } else {
//                backtrack(cur - 1, count, ch);
//                ch[cur] = '1';
//                backtrack(cur - 1, count + 1, ch);
//            }
//        } else {
//            if (ch[cur] == '1') {
//                ch[cur] = '0';
//                backtrack(cur - 1, count + 1, ch);
//                ch[cur] = '1';
//            } else {
//                backtrack(cur - 1, count, ch);
//            }
//        }
//    }

//    public int minFlipsMonoIncr(String s) {
//        int len = s.length();
//        if (len == 1) {
//            return 0;
//        }
//        int[] pre = new int[len + 1];
//        for (int i = 0; i < len; i++) {
//            pre[i + 1] = pre[i] + (s.charAt(i) - '0');
//        }
//        /*
//            前缀和，计算和，根据长度则可以计算 0 与 1 的个数
//            再在每个点切开，左边 1 反转 0 ，右边 0 反转 1
//            记录次数，寻找最少次数的切分点
//
//            前缀和 i   pre[i] = sum[0,i-1]
//            i == 0，则整个数组为右段
//            i == len，则整个数组为左段
//
//            左段 pre[i] 知道了 1 的个数，反转为 0，次数为 pre[i]
//            右段长度 len - i ,pre[len] - pre[i] 为 [i,len - 1]的和，即 1 的个数
//            长度 - 个数 == 0 的个数，即反转为 1 的次数
//            两段相加，得到最小的
//         */
//        int res = len;
//        for (int i = 0; i <= len; i++) {
//            res = Math.min(res, pre[i] + (len - i) - (pre[len] - pre[i]));
//        }
//        return res;
//    }

    public int minFlipsMonoIncr(String s) {
        /*
            简单DP思路：
            dp[i] 遍历到 i 使使字符串单调递增的最少次数
            如果s[i] == '1'，那么这个字符不影响翻转次数，
            故有：dp[i] = dp[i - 1]。
            若s[i] == '0'，那我们有两种情况：
            1. 将s[i]由0翻转到1。
            2. 将前面的字符串s[0:i-1]中所有1翻转到0，两种情况取最小值，
            有dp[i] = min{dp[i - 1] + 1, oneCount}。
            所以我们还得用一个变量记录1的数量。
         */
        int dp = 0;
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '1') {
                ++count;
            } else {
                dp = Math.min(dp + 1, count);
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        将字符串翻转到单调递增 res = new 将字符串翻转到单调递增();
        System.out.println(res.minFlipsMonoIncr("00011000"));
        System.out.println(res.minFlipsMonoIncr("100000001010000") + "\t3");
    }
}
