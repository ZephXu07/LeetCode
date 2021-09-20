package 每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: 停在原地的方案数
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-17
 */
public class 停在原地的方案数 {
//    private final int mod = 1_000_000_007;
//
//    private Map<String, Integer> memo;
//    public int numWays(int steps, int arrLen) {
//        memo = new HashMap<>();
//        return helper(steps, 0, arrLen);
//    }
//
//    private int helper(int steps, int cur, int len) {
//        if (steps == 0) {
//            return cur == 0 ? 1 : 0;
//        }
//        if (cur >= len || cur < 0) {
//            return 0;
//        }
//        String key = steps + "_" + cur;
//        if (memo.containsKey(key)) {
//            return memo.get(key);
//        }
//        long res = helper(steps - 1, cur + 1, len) % mod;
//        res += helper(steps - 1, cur, len) % mod;
//        res += helper(steps - 1, cur - 1, len) % mod;
//
//        res %= mod;
//        memo.put(key, (int)res);
//        return (int)res;
//    }


//    private final int mod = 1_000_000_007;
//    public int numWays(int steps, int arrLen) {
//        /*
//            dp[i][j] i 表示还有多少 steps， j 表示所处位置的坐标，
//             值表示当还有 i 步数，坐标为 j 共有多少方法
//         */
//        int max = Math.min(steps / 2, arrLen - 1);
//        //max表示步骤除以2与长度的最小值，当位置大于steps / 2 时回不去，所以可在此处进行比较
//        int[][] dp = new int[steps + 1][max + 1];
//
//        dp[steps][0] = 1;
//        //初始位置是 0 ，此时步数为题目提供的 steps
//
//        for (int i = steps - 1; i >= 0; i--) {
//            for (int j = 0; j <= max; j++) {
//                dp[i][j] = (dp[i][j] + dp[i + 1][j]) % mod;
//                //表示此步骤停留在原地
//                if (j - 1 >= 0) {
//                    dp[i][j] = (dp[i][j] + dp[i + 1][j - 1]) % mod;
//                    //当坐标大于等于1时可以向左走一步
//                }
//
//                if (j + 1 <= max) {
//                    dp[i][j] = (dp[i][j] + dp[i + 1][j + 1]) % mod;
//                    //当坐标小于max - 1时可以向右走一步
//                }
//
//            }
//        }
//
//        return dp[0][0];
//
//    }

//    private final int mod = 1_000_000_007;
//    public int numWays(int steps, int arrLen) {
//        /*
//            dp[i][j] i 表示还有多少 steps， j 表示所处位置的坐标，
//             值表示当还有 i 步数，坐标为 j 共有多少方法
//         */
//        int max = Math.min(steps / 2, arrLen - 1);
//        //max表示步骤除以2与长度的最小值，当位置大于steps / 2 时回不去，所以可在此处进行比较
//        int[][] dp = new int[steps + 1][max + 1];
//
//        dp[steps][0] = 1;
//        //初始位置是 0 ，此时步数为题目提供的 steps
//
//        for (int i = steps - 1; i >= 0; i--) {
//            int edge = Math.min(max, i);
//            //当剩余步数少于max时，走不到(edge, max]的位置，可进行时间剪枝
//            for (int j = 0; j <= edge; j++) {
//                dp[i][j] = (dp[i][j] + dp[i + 1][j]) % mod;
//                //表示此步骤停留在原地
//                if (j - 1 >= 0) {
//                    dp[i][j] = (dp[i][j] + dp[i + 1][j - 1]) % mod;
//                    //当坐标大于等于1时可以向左走一步
//                }
//
//                if (j + 1 <= max) {
//                    dp[i][j] = (dp[i][j] + dp[i + 1][j + 1]) % mod;
//                    //当坐标小于max - 1时可以向右走一步
//                }
//
//            }
//        }
//
//        return dp[0][0];
//
//    }

    private final int mod = 1_000_000_007;
    public int numWays(int steps, int arrLen) {
        /*
            dp[i][j] i 表示还有多少 steps， j 表示所处位置的坐标，
             值表示当还有 i 步数，坐标为 j 共有多少方法
         */
        int max = Math.min(steps / 2, arrLen - 1);
        //max表示步骤除以2与长度的最小值，当位置大于steps / 2 时回不去，所以可在此处进行比较
        int[][] dp = new int[2][max + 1];

        //使用一维dp代替，因为只用到前一排的

        dp[steps & 1][0] = 1;
        //初始位置是 0 ，此时步数为题目提供的 steps
        // steps & 1 获得奇偶，以当前排为起点

        for (int i = steps - 1; i >= 0; i--) {
            int edge = Math.min(max, i);
            //当剩余步数少于max时，走不到(edge, max]的位置，可进行时间剪枝

            int a = i & 1, b = (i + 1) & 1;
            //a是上个方法的当前排，b是上一排，代表还有多少步骤
            for (int j = 0; j <= edge; j++) {
                dp[a][j] = dp[b][j] % mod;
                //表示此步骤停留在原地
                if (j - 1 >= 0) {
                    dp[a][j] = (dp[a][j] + dp[b][j - 1]) % mod;
                    //当坐标大于等于1时可以向左走一步
                }

                if (j + 1 <= max) {
                    dp[a][j] = (dp[a][j] + dp[b][j + 1]) % mod;
                    //当坐标小于max - 1时可以向右走一步
                }

            }
        }

        return dp[0][0];



    }

    public static void main(String[] args) {
        停在原地的方案数 res = new 停在原地的方案数();
        System.out.println(res.numWays(4, 2));
    }
}
