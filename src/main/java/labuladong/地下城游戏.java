package labuladong;

/**
 * Title: labuladong.地下城游戏
 * Description: TODO
 *
 * @author zephxu
 * @version V1.0
 * @date 2020-12-31
 */
public class 地下城游戏 {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        int[][] dp = new int[rows][cols];
        int tmp = 1 - dungeon[rows - 1][cols - 1];
        dp[rows - 1][cols - 1] = tmp <= 0 ? 1 : tmp;
        for (int i = rows - 2; i >= 0; i--) {
            tmp = dp[i + 1][cols - 1] - dungeon[i][cols - 1];
            dp[i][cols - 1] = tmp <= 0 ? 1 : tmp;
        }
        for (int i = cols - 2; i >= 0; i--) {
            tmp = dp[rows - 1][i + 1] - dungeon[rows - 1][i];
            dp[rows - 1][i] = tmp <= 0 ? 1 : tmp;
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                tmp = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = tmp <= 0 ? 1 : tmp;
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        地下城游戏 game = new 地下城游戏();
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(game.calculateMinimumHP(dungeon));
    }
}
