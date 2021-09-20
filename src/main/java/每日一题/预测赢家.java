package 每日一题;

/**
 * Title: 预测赢家
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2021-06-16
 */
public class 预测赢家 {
    public boolean PredictTheWinner(int[] nums) {
        /*
                dp[i][j]
                当[i, j]堆石子时，当前玩家与另一个玩家石子数量之差的最大值
                由定义知当 i == j 时，石子只有一堆，当前玩家拿了，另一玩家为 0 ，此时数量之差最大值为这堆的石子数量
                再者，i > j，i < j 不存在这种情况

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

               计算 dp[i][j] 时需要知道 dp[i+1][j]
               计算 dp[i][j] 时需要知道 dp[i][j - 1]
               所以从后往前遍历，且单个石子已经计算了，所以 初始值 i + 1 = j
         */
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] >= 0;
    }

    public boolean PredictTheWinner1(int[] nums) {
      /*
                dp[i][j]
                当[i, j]堆石子时，当前玩家与另一个玩家石子数量之差的最大值
                由定义知当 i == j 时，石子只有一堆，当前玩家拿了，另一玩家为 0 ，此时数量之差最大值为这堆的石子数量
                再者，i > j，i < j 不存在这种情况

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

               计算 dp[i][j] 时需要知道 dp[i+1][j]
               计算 dp[i][j] 时需要知道 dp[i][j - 1]
               所以从后往前遍历，且单个石子已经计算了，所以 初始值 i + 1 = j

               降为一维
                            j - 1    j
               i
               i + 1
               由于 i 是往前遍历的，所以当前未计算的 i 是上一轮的 i + 1
               由于 j 是往后遍历的，所以当前未计算的 j 是上一轮的 j - 1
         */
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = nums[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[len - 1] > 0;
    }
}
