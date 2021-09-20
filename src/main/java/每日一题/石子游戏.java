package 每日一题;

/**
 * Title: 石子游戏
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-16
 */
public class 石子游戏 {
    public boolean stoneGame(int[] piles) {
        /*
                dp[i][j]
                当[i, j]堆石子时，当前玩家与另一个玩家石子数量之差的最大值
                由定义知当 i == j 时，石子只有一堆，当前玩家拿了，另一玩家为 0 ，此时数量之差最大值为这堆的石子数量
                再者，i >= j，i < j 不存在这种情况

                当 [i, j]堆石子时，当前玩家有两种选择
                pile[i]
                    当前玩家取了pile[i]，轮到另外玩家则是 [i+1,j]，
                    此时他计算的与另外玩家的差值最大值则是 dp[i+1][j]，
                    身份互换差值则是 - dp[i+1][j]，所以得到他选了 pile[i] 后剩下的差值，计算当前的则是
                    dp[i][j] = pile[i] - dp[i+1][j]
                pile[j]
                    当前玩家取了pile[j]，轮到另外玩家则是 [i,j - 1]，
                    此时他计算的与另外玩家的差值最大值则是 dp[i][j - 1]，
                    身份互换差值则是 - dp[i][j - 1]，所以得到他选了 pile[j] 后剩下的差值，计算当前的则是
                    dp[i][j] = piles[j] - dp[i][j - 1]

               因为两个玩家都是最好的情况，所以 dp[i][j] 的值为最大，
               这样最后比较数量才能获胜，所以需要取最大值

               因为是A 先开始的，石子堆是[0, len]，
               所以 A 与 B 的数量差值最大值是 dp[0][len - 1]
               因为题目所说总和为奇数，所以不可能为 0 ，当大于 0 时则是 A 获胜
               ，否则则是 B 获胜，所以判断是否大于 0 得到答案
         */
        int len = piles.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = piles[i];
        }

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] > 0;
    }

    public boolean stoneGame1(int[] piles) {
        /*
                dp[i][j]
                当[i, j]堆石子时，当前玩家与另一个玩家石子数量之差的最大值
                由定义知当 i == j 时，石子只有一堆，当前玩家拿了，另一玩家为 0 ，此时数量之差最大值为这堆的石子数量
                再者，i >= j，i < j 不存在这种情况

                当 [i, j]堆石子时，当前玩家有两种选择
                pile[i]
                    当前玩家取了pile[i]，轮到另外玩家则是 [i+1,j]，
                    此时他计算的与另外玩家的差值最大值则是 dp[i+1][j]，
                    身份互换差值则是 - dp[i+1][j]，所以得到他选了 pile[i] 后剩下的差值，计算当前的则是
                    dp[i][j] = pile[i] - dp[i+1][j]
                pile[j]
                    当前玩家取了pile[j]，轮到另外玩家则是 [i,j - 1]，
                    此时他计算的与另外玩家的差值最大值则是 dp[i][j - 1]，
                    身份互换差值则是 - dp[i][j - 1]，所以得到他选了 pile[j] 后剩下的差值，计算当前的则是
                    dp[i][j] = piles[j] - dp[i][j - 1]

               因为两个玩家都是最好的情况，所以 dp[i][j] 的值为最大，
               这样最后比较数量才能获胜，所以需要取最大值

               因为是A 先开始的，石子堆是[0, len]，
               所以 A 与 B 的数量差值最大值是 dp[0][len - 1]
               因为题目所说总和为奇数，所以不可能为 0 ，当大于 0 时则是 A 获胜
               ，否则则是 B 获胜，所以判断是否大于 0 得到答案
         */
        int len = piles.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = piles[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
            }
        }
        return dp[len - 1] > 0;
    }

    public boolean stoneGame2(int[] piles) {
        /*
        将数组按下标奇偶分序号，按题意 A 取一个，B 取一个，因为他们都会做出最佳选择
        因此只会分成两组，前面的一堆在偶数组，后面的在奇数组

        0 1 2 3                     0 1 2 3
        5 3 4 5                     3 7 2 3
        A 0-5，B 3-5               A 3-3, B 0-3
        A 2-4，B 1-3               A 1-7, B 2-2

        无论怎么取， A 都可以选最大的那一组，只要在分组后计算哪一组和最大，所以 A 先手可以获胜

         */
        return true;
    }
}
