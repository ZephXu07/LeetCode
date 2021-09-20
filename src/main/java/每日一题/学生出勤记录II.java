package 每日一题;

/**
 * Title: 学生出勤记录II
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-08-17
 */
public class 学生出勤记录II {
//    private int n;
//    private static final int MOD = (int) (1e9 + 7);
//    public int checkRecord(int n) {
//        this.n = n;
//        return dfs(0, 0, 0);
//    }
//    private int dfs (int len, int absent, int late) {
//        if (len == n) {
//            return 1;
//        }
//        int ans = 0;
//        ans = (ans + dfs(len + 1, absent, 0)) % MOD;
//        /*
//            无论前面什么情况，到达这里都是正常的，准时，absent不变，连续迟到归 0
//         */
//
//        if (absent < 1) {
//            ans = (ans + dfs(len + 1, 1, 0)) % MOD;
//            /*
//                没有旷课过，这次可以旷课
//                absent = 1
//                连续迟到归 0
//             */
//        }
//
//        if (late < 2) {
//            ans = (ans + dfs(len + 1, absent, late + 1)) % MOD;
//            /*
//                只有昨天迟到了，今天可以迟到
//                absent 不变，连续迟到为 2
//             */
//        }
//
//        return ans;
//        /*
//            返回结果
//         */
//    }

//    private int n;
//    private int[][][] memo;
//
//    private static final int MOD = (int) (1e9 + 7);
//    public int checkRecord(int n) {
//        this.n = n;
//        memo = new int[n][2][3];
//         /*
//        memo[i][j][k]
//        i 第几天，n 直接返回，所以长度为 n 即可
//        j absent 缺席几次了，因为能拿奖的只有 0 1，所以长度 2
//        k 连续 late 几次了，因为能拿奖的只有不迟到 0 ，只连续迟到 1 天，只连续迟到 2 天，所以长度 3
//     */
//        return dfs(0, 0, 0);
//    }
//    private int dfs (int len, int absent, int late) {
//        if (len == n) {
//            return 1;
//        }
//        if (memo[len][absent][late] != 0) {
//            return memo[len][absent][late];
//            /*
//                计算过直接返回
//             */
//        }
//        int ans = 0;
//        ans = (ans + dfs(len + 1, absent, 0)) % MOD;
//        /*
//            无论前面什么情况，到达这里都是正常的，准时，absent不变，连续迟到归 0
//         */
//
//        if (absent < 1) {
//            ans = (ans + dfs(len + 1, 1, 0)) % MOD;
//            /*
//                没有旷课过，这次可以旷课
//                absent = 1
//                连续迟到归 0
//             */
//        }
//
//        if (late < 2) {
//            ans = (ans + dfs(len + 1, absent, late + 1)) % MOD;
//            /*
//                只有昨天迟到了，今天可以迟到
//                absent 不变，连续迟到为 2
//             */
//        }
//
//        memo[len][absent][late] = ans;
//        return ans;
//        /*
//            返回结果
//         */
//    }

    public int checkRecord(int n) {
        int mod = (int) 1e9 + 7;
        long[][][] dp = new long[n][2][3];
        /*
            i 第 i-1 天，n 直接返回，所以长度为 n 即可
            j absent 缺席几次了，因为能拿奖的只有 0 1，所以长度 2
            k 连续 late 几次了，因为能拿奖的只有不迟到 0 ，只连续迟到 1 天，只连续迟到 2 天，所以长度 3
         */

        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        dp[0][1][0] = 1;
        /*
            初始化
            第一天，无论是到场，旷课，迟到的情况只有一种
         */

        for (int i = 1; i < n; i++) {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % mod;
            dp[i][1][0] = (dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % mod;
            /*
                今天是准时到达
                即旷课 0 天，连续迟到 0 天
                能从昨天的 旷课 0 天，连续迟到 0，1，2 天 转移而来

                同理旷课 1 天，连续迟到 0 天
                能从昨天的 旷课 1 天，连续迟到 0，1，2 天 转移而来
             */

            dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % mod;
            /*
                今天是旷课
                即旷课  1 天，即连续迟到 0 天
                能从昨天的 旷课 0 天，连续迟到 0，1，2 天转移而来
                还有这种状态也可能是旷课 1 天，连续迟到 0 天转移而来
             */

            dp[i][0][1] = dp[i - 1][0][0];
            dp[i][0][2] = dp[i - 1][0][1];
            dp[i][1][1] = dp[i - 1][1][0];
            dp[i][1][2] = dp[i - 1][1][1];
            /*
                这次是迟到
                有旷课 0, 1天，和连续迟到 1，2天
             */



        }

        /*
            旷课 0、1 天
            连续 0、1、2 天迟到都是满足的
         */
        int res = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                res = (int) ((res + dp[n - 1][i][j]) % mod);
            }
        }

        return res;
    }



    public static void main(String[] args) {
        学生出勤记录II res = new 学生出勤记录II();
        System.out.println(res.checkRecord(2));
    }
}
