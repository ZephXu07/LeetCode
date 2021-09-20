package codetop;

/**
 * Title: 石子游戏二
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-09-09
 */
public class 石子游戏二 {
//    public int stoneGameII(int[] piles) {
//        int len = piles.length;
//        int[] suffix = new int[len];
//        suffix[len - 1] = piles[len - 1];
//        for (int i = len - 2; i >= 0; i--) {
//            suffix[i] = suffix[i + 1] + piles[i];
//        }
//        /*
//            后缀和 suffix[i] i 下标及到结尾的和
//         */
//
//        int[][] memo = new int[len][len];
//        /*
//            剩 i下标及以后的石子堆且一次可以取 X 堆(1<=X<=2M) 时，
//            能获取的最大石子数量
//         */
//
//        return dfs(len, memo, 0, 1, suffix);
//    }
//
//    private int dfs (int len, int[][] memo, int inx, int M, int[] suffix) {
//        if (inx == len) {
//            return 0;
//            /*
//                没有石子了，结束
//             */
//        }
//
//
//        if (inx + 2 * M >= len) {
//            return suffix[inx];
//            /*
//                当前的石子堆是 [inx,n)
//                最大取 2M 堆
//                inx+2M>=len 表示一次性可以取完
//                所以直接取完
//             */
//        }
//
//        if (memo[inx][M] != 0) {
//            /*
//                已经计算了这种情况，直接返回
//             */
//            return memo[inx][M];
//        }
//
//        /*
//            到这里表示不能一次性取完
//            所以枚举取多少堆
//            i[1,2M]堆，而取完后剩下 [inx+i,n)堆
//            此时计算另外玩家在 [inx+i,n)堆 取到的最大数
//            使其最大数最小，此时自己取到的最大数则是最大的
//         */
//        int m2 = 2 * M;
//        int res = 0;
//        for (int i = 1; i <= m2; i++) {
//            res = Math.max(res,
//                    suffix[inx] - dfs(len, memo, i + inx, Math.max(i, M), suffix));
//            /*
//                suffix[inx] 是 [inx,len) 减去另一玩家获得的最大最小石子数 [inx+i,len)
//                就是当前玩家能获得的最大最大石子数
//             */
//        }
//        memo[inx][M] = res;
//        /*
//            存储
//         */
//        return res;
//    }

    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int suffix = 0;
        /*
            后缀和，待会儿是从右往左遍历
         */
        int[][] dp = new int[len][len + 1];
        /*
            dp[i][j] 表示在 [i,n-1] 石子区间内，M == j 时，当前玩家最多的石子数量
         */
        for (int i = len - 1; i >= 0; i--) {
            suffix += piles[i];
            for (int j = 1; j <= len; j++) {
                if (i + 2 * j >= len) {
                    dp[i][j] = suffix;
                } else {
                    for (int k = 1; k <= 2 * j; k++) {
                        dp[i][j] = Math.max(dp[i][j],
                                suffix - dp[i + k][Math.max(k, j)]);
                    }
                }
            }
            /*
                如果当前玩家从[i...i+k-1]选了这个范围的石子，
                留给另外一个玩家的选择范围是[i+k...max(j,k)]，而

                如果i+2j 到达了石子堆的末尾，即i+2j>=len的时候，
                对于当前玩家，最好的方案是全部取走石子，即dp[i][j]=sum[i,n-1]

                如果i+2j<n,则dp[i][j]=max{f[i][j],sum[i,n-1]-dp[i+k][max(j,k)]}
                这里的k在[1,2M]范围内

                j 的最大范围即 len
             */
        }
        return dp[0][1];
    }


    public static void main(String[] args) {
        石子游戏二 res = new 石子游戏二();
        System.out.println(res.stoneGameII(new int[]{2, 7, 9, 4, 4}));
    }
}
