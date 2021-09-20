package labuladong;

/**
 * Title: labuladong.StoneGame
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-11-28
 */
public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][][] dp = new int[len][len][2];
        for (int i = 0; i < len; i++) {
            dp[i][i][0] = piles[i];
        }
        for (int n = 2; n <= len; n++) {
            for (int i = 0; i <= len - n; i++) {
                int j = n + i - 1;
                int left = piles[i] + dp[i + 1][j][1];
                int right = piles[j] + dp[i][j - 1][1];
                if (left > right) {
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }
        return dp[0][len - 1][0] > dp[0][len - 1][1];
    }

    public static void main(String[] args) {
        StoneGame stoneGame = new StoneGame();
        int[] stones = new int[]{1,2,3,7};
        System.out.println(stoneGame.stoneGame(stones));
    }
}
