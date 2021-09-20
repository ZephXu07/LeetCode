package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 一和零
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-06
 */
public class 一和零 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[] count = new int[len];
        for (int i = 0; i < len; i++) {
            String s = strs[i];
            for (int j = 0; j < s.length(); j++) {
                count[i] += s.charAt(j) - '0';
            }
        }
        /* 统计字符串中 1 的数目，
            再由字符串的长度计算 0 的数目
         */

        int[][][] dp = new int[len][m + 1][n + 1];
        /*
            i 前 i + 1 个字符
            m 使用了 m 个 0
            n 使用了 n 个 1
            结果是能构建多少个前 i + 1 个字符串中的某些字符串，即子集
         */
        for (int z = 0; z <= m; z++) {
            for (int o = 0; o <= n; o++) {
                if (z >= strs[0].length() - count[0]
                        && o >= count[0]) {
                    dp[0][z][o] = 1;
                }
            }
        }
        //免去第 0 个字符串时的判断

        for (int i = 1; i < len; i++) {
            for (int z = 0; z <= m; z++) {
                for (int o = 0; o <= n; o++) {
                    int no = dp[i - 1][z][o];
                    int yes = 0;
                    int tmp = strs[i].length() - count[i];
                    if (z >= tmp && o >= count[i]) {
                        yes = dp[i - 1][z - tmp][o - count[i]] + 1;
                    }
                    dp[i][z][o] = Math.max(yes, no);
                }
            }
        }

        return dp[len - 1][m][n];
    }

    public int findMaxForm1(String[] strs, int m, int n) {
        int len = strs.length;
        int[] count = new int[len];
        for (int i = 0; i < len; i++) {
            String s = strs[i];
            for (int j = 0; j < s.length(); j++) {
                count[i] += s.charAt(j) - '0';
            }
        }
        /* 统计字符串中 1 的数目，
            再由字符串的长度计算 0 的数目
         */

        /*
            一点优化，每次都是在上一行的基础上重新构建新的行，所以可以使用两行代替， & 1 得到坐标是 0 还是 1
         */

        int[][][] dp = new int[2][m + 1][n + 1];
        /*
            i 前 i + 1 个字符
            m 使用了 m 个 0
            n 使用了 n 个 1
            结果是能构建多少个前 i + 1 个字符串中的某些字符串，即子集
         */
        for (int z = 0; z <= m; z++) {
            for (int o = 0; o <= n; o++) {
                if (z >= strs[0].length() - count[0]
                        && o >= count[0]) {
                    dp[0][z][o] = 1;
                }
            }
        }
        //免去第 0 个字符串时的判断

        for (int i = 1; i < len; i++) {
            for (int z = 0; z <= m; z++) {
                for (int o = 0; o <= n; o++) {
                    int no = dp[(i - 1) & 1][z][o];
                    int yes = 0;
                    int tmp = strs[i].length() - count[i];
                    if (z >= tmp && o >= count[i]) {
                        yes = dp[(i - 1) & 1][z - tmp][o - count[i]] + 1;
                    }
                    dp[i & 1][z][o] = Math.max(yes, no);
                }
            }
        }

        return dp[(len - 1) & 1][m][n];
    }




    public static void main(String[] args) {
        一和零 res = new 一和零();
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;
        System.out.println(res.findMaxForm(strs, m, n));
        System.out.println(res.findMaxForm1(strs, m, n));


    }
}
