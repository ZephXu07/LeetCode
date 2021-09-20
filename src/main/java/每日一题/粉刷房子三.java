package 每日一题;

/**
 * Title: 粉刷房子三
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-05-04
 */
public class 粉刷房子三 {




    private static final int INF = Integer.MAX_VALUE / 2;
    //(0)

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        /*
            房子 0 -> m-1
    (0)     颜色 0 -> n-1
            街区 0 -> target - 1
            因为题目和我们的定义不同，先减 1
         */

        /*
    (1)     dp[i][j][k]表示[0, i]的房子涂上色，
            最末尾房子颜色为 j
            且它是第 k 个街区时最少花费


            第 i - 1房子为 j0颜色
            房子 i 如果涂过色：

                如果不是我们要的 j 颜色，不合我们的要求，
                舍去此种，花费设置极大值INF  (2)
                （为int最大值除以2，不用最大是怕在计算中加上cost溢出了
                我的想法是大于所有房子都填充，
                根据题目给的最大花费算上最多的房子，
                即 100 * 10000 = 1000000，比这个数大就行）
                dp[i][j][k] = INF

      (3)       如果是我们要的 j 颜色
                    如果和前一个房子颜色一样，即 j = j0时，
                    此时街区数不变，颜色不变，也不需要花钱，
          (3)(0)    则 i - 1花费了多少此时也花费了多少
                    dp[i][j][k] = dp[i - 1][j][k]

         (3)(1)     如果和前一个房子颜色不一样，即 j != j0
                    此时街区数增加，颜色变化了，但不需要花钱
                    dp[i][j][k]最终花费是dp[i][j][k]与dp[i-1][j0][k-1]中的最小值
                    dp[i][j][k] = min(dp[i][j][k], dp[i-1][j0][k-1])
                    （因为刚开始的初始化，且i,j,k在一直变化的，而dp定义的是求最小的，所以比较）

            房子 i 如果没有涂过色：
                此时与上面分析的一样的那些情况都一样，区别的是要花费多少，需要计算进去
                dp[i][j][k] = dp[i - 1][j][k] + cost[i][j]
                dp[i][j][k] = min(dp[i][j][k], dp[i-1][j0][k-1]) + cost[i][j]

                于是决定先判断是哪种情况，
                再根据hourse是否为 -1 来判断是否加入花费的钱


            几种特殊的情况
    (4)         k = 0，表示第一个街区，肯定没办法从 k - 1 = -1街区转移来

                i = 0，表示第一个房子，也无法从 i - 1 = -1转移而来，
                且第一间房子无论涂什么颜色 k = 0，即只有一个街区，
                此时 k > 0的都是不符要求，怎么可能一间房子一种颜色有多个街区


     (4)(0)     dp[0][j][0] = INF 不是我们想要的颜色
      (4)(1)                = 0   已有颜色，且是我们想要的颜色，第一间房子一个颜色组成第一个街区
       (4)(2)               = cost[i][j]  没有颜色，涂成我们想要的





         */

        for (int i = 0; i < m; i++) {
            houses[i]--;
            //(0)
        }

        //(1)
        int[][][] dp = new int[m][n][target];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < target; k++) {
                    /*
                        初始化为最大
                     */
                    dp[i][j][k] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (houses[i] != -1 && houses[i] != j) {
                    continue;
                    //涂过色，不是我们要的那种颜色(2)
                }

                for (int k = 0; k < target; k++) {
                    for (int j0 = 0; j0 < n; j0++) {
                        if (j == j0) {
                            //当前颜色与前一间一样(3)
                            if (i == 0) {
                                if (k == 0) {
                                    dp[i][j][k] = 0;
                                    //(4)(1)
                                }
                                //(4)(0)由之前的初始化
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
                               // (3)(0)
                            }
                        } else if (i > 0 && k > 0) {
                            //由(4)知道这里i 和 k 需要判断一下范围
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j0][k - 1]);
                            //(3)(1)
                        }
                    }
                    if (dp[i][j][k] != INF && houses[i] == -1){
                        //不是最大是因为经过前面的计算不可能需要涂色还是极大值，减少错误干扰
                        //根据是否涂过色来计算是否需要花费
                        dp[i][j][k] += cost[i][j];
                    }

                }

            }


        }

        int res = INF;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[m - 1][j][target - 1]);
            //判断每种颜色的m间房涂成target个街区的最小花费
        }
        return res == INF ? -1 : res;


    }
}
